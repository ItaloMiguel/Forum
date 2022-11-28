package br.com.api.forum.factory.topico;

import br.com.api.forum.model.Topico;
import br.com.api.forum.payload.response.TopicosReponseDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class TopicoFactory {

    private Page<TopicosReponseDto> topicosReponseDtos;
    private TopicosReponseDto topicosReponseDto;

    public TopicoFactory converterParaUmaListaPage(Page<Topico> topicoList) {
        this.topicosReponseDtos = topicoList.map(TopicosReponseDto::new);
        return this;
    }


    public TopicoFactory converter(Topico topico) {
        this.topicosReponseDto = new TopicosReponseDto(topico);
        return this;
    }

    public Page<TopicosReponseDto> buildList() {
        return this.topicosReponseDtos;
    }

    public TopicosReponseDto build() {
        return this.topicosReponseDto;
    }
}
