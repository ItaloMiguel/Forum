package br.com.api.forum.factory.topico;

import br.com.api.forum.model.Topico;
import br.com.api.forum.payload.response.DetalheTopicosResponseDto;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicoDetalheFactory {

    private DetalheTopicosResponseDto detalheTopicosResponseDto;


    public TopicoDetalheFactory converter(Topico topico) {
        this.detalheTopicosResponseDto = new DetalheTopicosResponseDto(topico);
        return this;
    }

    public DetalheTopicosResponseDto build() {
        return this.detalheTopicosResponseDto;
    }
}
