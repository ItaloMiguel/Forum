package br.com.api.forum.controller;

import br.com.api.forum.payload.response.TopicosResponseDto;
import br.com.api.forum.service.TopicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topicos")
public class TopicoCotroller {

    private final TopicoService topicoService;

    public TopicoCotroller(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @GetMapping
    public ResponseEntity<List<TopicosResponseDto>> listAll() {
        List<TopicosResponseDto> topicosResponseDtos = topicoService.listAll();
        return ResponseEntity.ok().body(topicosResponseDtos);
    }
}
