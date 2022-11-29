package br.com.api.forum.service.impl;

import br.com.api.forum.exceptions.CursoNotFoundException;
import br.com.api.forum.exceptions.TopicoNotFoundException;
import br.com.api.forum.factory.topico.TopicoDetalheFactory;
import br.com.api.forum.factory.topico.TopicoFactory;
import br.com.api.forum.model.Topico;
import br.com.api.forum.payload.request.TopicosRequestDto;
import br.com.api.forum.payload.response.DetalheTopicosResponseDto;
import br.com.api.forum.payload.response.TopicosReponseDto;
import br.com.api.forum.repository.RepositirioDeTopicoH2;
import br.com.api.forum.repository.RepositorioDeCursoH2;
import br.com.api.forum.service.TopicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TopicoServiceImpl implements TopicoService {

    private final RepositirioDeTopicoH2 repositorioDeTopicos;
    private final RepositorioDeCursoH2 repositorioDeCurso;

    private final TopicoFactory topicoFactory;
    private final TopicoDetalheFactory topicoDetalheFactory;

    public TopicoServiceImpl(RepositirioDeTopicoH2 repositorioDeTopicos, RepositorioDeCursoH2 repositorioDeCurso, TopicoFactory topicoFactory, TopicoDetalheFactory topicoDetalheFactory) {
        this.repositorioDeTopicos = repositorioDeTopicos;
        this.repositorioDeCurso = repositorioDeCurso;
        this.topicoFactory = topicoFactory;
        this.topicoDetalheFactory = topicoDetalheFactory;
    }

    @Override
    @Transactional
    public Page<TopicosReponseDto> findByCursoNome(String nomeCurso, Pageable paginacao) {
        Page<Topico> topicosPage = repositorioDeTopicos.findByCursoNome(nomeCurso, paginacao).orElseGet(() -> repositorioDeTopicos.findAll(paginacao));
        return this.topicoFactory.converterParaUmaListaPage(topicosPage).buildList();
    }

    @Override
    @Transactional
    public Page<TopicosReponseDto> listAll(Pageable paginacao) {
        Page<Topico> topicoList = repositorioDeTopicos.findAll(paginacao);
        return this.topicoFactory.converterParaUmaListaPage(topicoList).buildList();
    }

    @Override
    @Transactional
    public DetalheTopicosResponseDto findById(Long id) {
        Topico topico = repositorioDeTopicos.findById(id).orElseThrow(() -> new CursoNotFoundException(id.toString()));
        return this.topicoDetalheFactory.converter(topico).build();
    }

    @Override
    @Transactional
    public TopicosReponseDto save(TopicosRequestDto requestDto) {
        Topico topico = requestDto.converter(repositorioDeCurso);
        repositorioDeTopicos.save(topico);
        return this.topicoFactory.converter(topico).build();
    }

    @Override
    @Transactional
    public TopicosReponseDto atualizar(TopicosRequestDto requestDto, Long id) {
        Topico topico = repositorioDeTopicos.findById(id).orElseThrow(() -> new TopicoNotFoundException(id));
        Topico topicoAtualizado = topico.atualizar(requestDto, repositorioDeCurso);
        repositorioDeTopicos.save(topicoAtualizado);
        return this.topicoFactory.converter(topicoAtualizado).build();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repositorioDeTopicos.deleteById(id);
    }
}
