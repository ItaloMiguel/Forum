package br.com.api.forum.service;

import br.com.api.forum.payload.request.TopicosRequestDto;
import br.com.api.forum.payload.response.DetalheTopicosResponseDto;
import br.com.api.forum.payload.response.TopicosReponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

public interface TopicoService {

    TopicosReponseDto save(TopicosRequestDto requestDto);

    Page<TopicosReponseDto> findByCursoNome(String nomeCurso, Pageable paginacao);

    Page<TopicosReponseDto> listAll(Pageable paginacao);

    DetalheTopicosResponseDto findById(Long id);

    void delete(Long id);

    TopicosReponseDto atualizar(TopicosRequestDto requestDto, Long id);
}
