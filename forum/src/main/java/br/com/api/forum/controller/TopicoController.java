package br.com.api.forum.controller;

import br.com.api.forum.payload.request.TopicosRequestDto;
import br.com.api.forum.payload.response.MessagemResponse;
import br.com.api.forum.payload.response.TopicosResponseDto;
import br.com.api.forum.service.TopicoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<TopicosResponseDto>> listarTudo() {
        List<TopicosResponseDto> topicosResponseDtos = topicoService.listAll();
        return ResponseEntity.ok().body(topicosResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicosResponseDto> detalhar(@PathVariable("id") Long id) {
        TopicosResponseDto service = topicoService.findById(id);
        return ResponseEntity.ok().body(service);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid TopicosRequestDto requestDto, UriComponentsBuilder uriBuilder) {
        TopicosResponseDto topicosResponseDto = topicoService.save(requestDto);
        URI uri = uriBuilder.path("/api/v1/topicos/{id}").buildAndExpand(topicosResponseDto.getId()).toUri();
        return ResponseEntity.created(uri).body(new MessagemResponse("Tópico criado com sucesso!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody @Valid TopicosRequestDto requestDto, @PathVariable("id") Long id,
                                       UriComponentsBuilder uriBuilder) {
        TopicosResponseDto topicosResponseDto = topicoService.atualizar(requestDto, id);
        URI uri = uriBuilder.path("/api/v1/topicos/{id}").buildAndExpand(topicosResponseDto.getId()).toUri();
        return ResponseEntity.ok().body(new MessagemResponse("Tópico atualizado com sucesso!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        topicoService.delete(id);
        return ResponseEntity.ok().body(new MessagemResponse("Tópico removido com sucesso!"));
    }
}
