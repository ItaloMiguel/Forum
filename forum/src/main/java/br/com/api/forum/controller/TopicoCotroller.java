package br.com.api.forum.controller;

import br.com.api.forum.payload.request.TopicosRequestDto;
import br.com.api.forum.payload.response.MessagemResponse;
import br.com.api.forum.payload.response.TopicosResponseDto;
import br.com.api.forum.service.TopicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> cadastrar(@RequestBody TopicosRequestDto requestDto) {
        topicoService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessagemResponse("Topico criado com sucesso!"));
    }
}
