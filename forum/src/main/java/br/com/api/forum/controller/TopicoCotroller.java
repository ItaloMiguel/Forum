package br.com.api.forum.controller;

import br.com.api.forum.payload.request.TopicosRequestDto;
import br.com.api.forum.payload.response.MessagemResponse;
import br.com.api.forum.payload.response.TopicosResponseDto;
import br.com.api.forum.service.TopicoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/topicos")
public class TopicoCotroller {

    private final TopicoService topicoService;

    public TopicoCotroller(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<TopicosResponseDto>> listAll() {
        List<TopicosResponseDto> topicosResponseDtos = topicoService.listAll();
        return ResponseEntity.ok().body(topicosResponseDtos);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid TopicosRequestDto requestDto, UriComponentsBuilder uriBuilder) {
        TopicosResponseDto topicosResponseDto = topicoService.save(requestDto);
        URI uri = uriBuilder.path("/api/v1/topicos/{id}").buildAndExpand(topicosResponseDto.getId()).toUri();
        return ResponseEntity.created(uri).body(new MessagemResponse("Topico criado com sucesso!"));
    }
}
