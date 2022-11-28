package br.com.api.forum.factory.topico;

import br.com.api.forum.model.Topico;
import br.com.api.forum.payload.response.TopicosReponseDto;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class TopicoFactory {

    private List<TopicosReponseDto> topicosReponseDtos;
    private TopicosReponseDto topicosReponseDto;

    public TopicoFactory converterParaUmaLista(List<Topico> topicoList) {
        this.topicosReponseDtos = topicoList.stream().map(TopicosReponseDto::new).collect(Collectors.toList());
        return this;
    }


    public TopicoFactory converter(Topico topico) {
        this.topicosReponseDto = new TopicosReponseDto(topico);
        return this;
    }

    public List<TopicosReponseDto> buildList() {
        return this.topicosReponseDtos;
    }

    public TopicosReponseDto build() {
        return this.topicosReponseDto;
    }
}
