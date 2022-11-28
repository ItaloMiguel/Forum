package br.com.api.forum.service.impl;

import br.com.api.forum.exceptions.CursoNotFoundException;
import br.com.api.forum.exceptions.TopicoNotFoundException;
import br.com.api.forum.factory.topico.TopicoFactory;
import br.com.api.forum.model.Topico;
import br.com.api.forum.payload.request.TopicosRequestDto;
import br.com.api.forum.payload.response.TopicosResponseDto;
import br.com.api.forum.repository.RepositirioDeTopicoH2;
import br.com.api.forum.repository.RepositorioDeCursoH2;
import br.com.api.forum.service.TopicoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
@Transactional
public class TopicoServiceImpl implements TopicoService {

    private final RepositirioDeTopicoH2 repositorioDeTopicos;
    private final RepositorioDeCursoH2 repositorioDeCurso;

    private final TopicoFactory topicoFactory;

    public TopicoServiceImpl(RepositirioDeTopicoH2 repositorioDeTopicos, RepositorioDeCursoH2 repositorioDeCurso, TopicoFactory topicoFactory) {
        this.repositorioDeTopicos = repositorioDeTopicos;
        this.repositorioDeCurso = repositorioDeCurso;
        this.topicoFactory = topicoFactory;
    }

    @Override
    public List<TopicosResponseDto> listAll() {
        List<Topico> topicoList = repositorioDeTopicos.findAll();
        return this.topicoFactory.converterParaUmaLista(topicoList).buildList();
    }

    @Override
    public TopicosResponseDto findById(Long id) {
        Topico topico = repositorioDeTopicos.findById(id).orElseThrow(() -> new CursoNotFoundException(id.toString()));
        return this.topicoFactory.converter(topico).build();
    }

    @Override
    public TopicosResponseDto save(TopicosRequestDto requestDto) {
        Topico topico = requestDto.converter(repositorioDeCurso);
        repositorioDeTopicos.save(topico);
        return this.topicoFactory.converter(topico).build();
    }

    @Override
    public TopicosResponseDto atualizar(TopicosRequestDto requestDto, Long id) {
        Topico topico = repositorioDeTopicos.findById(id).orElseThrow(() -> new TopicoNotFoundException(id));
        Topico topicoAtualizado = topico.atualizar(requestDto, repositorioDeCurso);
        repositorioDeTopicos.save(topicoAtualizado);
        return this.topicoFactory.converter(topicoAtualizado).build();
    }

    @Override
    public void delete(Long id) {
        repositorioDeTopicos.deleteById(id);
    }
}
