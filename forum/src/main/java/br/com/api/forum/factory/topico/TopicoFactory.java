package br.com.api.forum.factory.topico;

import br.com.api.forum.model.Topico;
import br.com.api.forum.payload.request.TopicosRequestDto;
import br.com.api.forum.payload.response.TopicosResponseDto;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class TopicoFactory {

    private TopicosResponseDto topicosResponseDto;
    private List<TopicosResponseDto> topicosResponseDtoList;
    private Topico topico;

    public TopicoFactory converterParaUmaLista(List<Topico> topicos) {
        this.topicosResponseDtoList = topicos.stream()
                .map(topico -> new TopicosResponseDto(
                        topico.getId(),
                        topico.getTitulo(),
                        topico.getMensagem(),
                        topico.getDataCriacao(),
                        topico.getStatus(),
                        topico.getAutor(),
                        topico.getCurso(),
                        topico.getRespostas()
                )).collect(Collectors.toList());
        return this;
    }

    public TopicoFactory converter(Topico topico) {
        this.topicosResponseDto = new TopicosResponseDto(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getRespostas());
        return this;
    }

    public List<TopicosResponseDto> buildList() {
        return this.topicosResponseDtoList;
    }

    public TopicosResponseDto build() {
        return this.topicosResponseDto;
    }
}
