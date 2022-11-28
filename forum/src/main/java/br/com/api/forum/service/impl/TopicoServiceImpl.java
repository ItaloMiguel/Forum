package br.com.api.forum.service.impl;

import br.com.api.forum.factory.topico.TopicoFactory;
import br.com.api.forum.model.Topico;
import br.com.api.forum.payload.response.TopicosResponseDto;
import br.com.api.forum.repository.RepositirioDeTopicoH2;
import br.com.api.forum.service.TopicoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoServiceImpl implements TopicoService {

    private final RepositirioDeTopicoH2 repositorioDeTopicos;
    private final TopicoFactory topicoFactory;

    public TopicoServiceImpl(RepositirioDeTopicoH2 repositorioDeTopicos, TopicoFactory topicoFactory) {
        this.repositorioDeTopicos = repositorioDeTopicos;
        this.topicoFactory = topicoFactory;
    }

    @Override
    public List<TopicosResponseDto> listAll() {
        List<Topico> topicos = repositorioDeTopicos.findAll();
        return this.topicoFactory.converterParaUmaLista(topicos).buildList();
    }
}
