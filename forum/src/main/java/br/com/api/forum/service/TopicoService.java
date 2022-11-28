package br.com.api.forum.service;

import br.com.api.forum.payload.request.TopicosRequestDto;
import br.com.api.forum.payload.response.TopicosResponseDto;

import java.util.*;

public interface TopicoService {

    List<TopicosResponseDto> listAll();

    void save(TopicosRequestDto requestDto);
}
