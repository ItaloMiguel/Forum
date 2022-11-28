package br.com.api.forum.service;

import br.com.api.forum.payload.request.TopicosRequestDto;
import br.com.api.forum.payload.response.DetalheTopicosResponseDto;
import br.com.api.forum.payload.response.TopicosReponseDto;

import java.util.*;

public interface TopicoService {

    TopicosReponseDto save(TopicosRequestDto requestDto);

    List<TopicosReponseDto> listAll();

    DetalheTopicosResponseDto findById(Long id);

    void delete(Long id);

    TopicosReponseDto atualizar(TopicosRequestDto requestDto, Long id);
}
