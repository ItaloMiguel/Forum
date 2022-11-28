package br.com.api.forum.service;

import br.com.api.forum.payload.request.TopicosRequestDto;
import br.com.api.forum.payload.response.TopicosResponseDto;

import java.util.*;

public interface TopicoService {

    TopicosResponseDto save(TopicosRequestDto requestDto);

    List<TopicosResponseDto> listAll();

    TopicosResponseDto findById(Long id);

    void delete(Long id);

    TopicosResponseDto atualizar(TopicosRequestDto requestDto, Long id);
}
