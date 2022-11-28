package br.com.api.forum.controller;

import br.com.api.forum.payload.request.TopicosRequestDto;
import br.com.api.forum.payload.response.DetalheTopicosResponseDto;
import br.com.api.forum.payload.response.MessagemResponse;
import br.com.api.forum.payload.response.TopicosReponseDto;
import br.com.api.forum.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @GetMapping(produces = "application/json")
    @Cacheable(value = "listaDeTopicos")
    public ResponseEntity<Page<TopicosReponseDto>> listarTodos(
            @RequestParam(required = false) String nomeCurso,
            @PageableDefault(sort = "id", size = 5,  direction = Sort.Direction.ASC)
            Pageable paginacao) {

        if (nomeCurso != null) {
            Page<TopicosReponseDto> topicosReponseDtos = topicoService.findByCursoNome(nomeCurso, paginacao);
            return ResponseEntity.ok().body(topicosReponseDtos);
        }
        Page<TopicosReponseDto> topicosResponseDtos = topicoService.listAll(paginacao);
        return ResponseEntity.ok().body(topicosResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheTopicosResponseDto> detalhar(@PathVariable("id") Long id) {
        DetalheTopicosResponseDto service = topicoService.findById(id);
        return ResponseEntity.ok().body(service);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid TopicosRequestDto requestDto, UriComponentsBuilder uriBuilder) {
        TopicosReponseDto topicosResponseDto = topicoService.save(requestDto);
        URI uri = uriBuilder.path("/api/v1/topicos/{id}").buildAndExpand(topicosResponseDto.getId()).toUri();
        return ResponseEntity.created(uri).body(new MessagemResponse("Tópico criado com sucesso!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody @Valid TopicosRequestDto requestDto, @PathVariable("id") Long id,
                                       UriComponentsBuilder uriBuilder) {
        TopicosReponseDto topicosResponseDto = topicoService.atualizar(requestDto, id);
        URI uri = uriBuilder.path("/api/v1/topicos/{id}").buildAndExpand(topicosResponseDto.getId()).toUri();
        return ResponseEntity.ok().body(new MessagemResponse("Tópico atualizado com sucesso!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        topicoService.delete(id);
        return ResponseEntity.ok().body(new MessagemResponse("Tópico removido com sucesso!"));
    }
}
