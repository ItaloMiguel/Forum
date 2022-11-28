package br.com.api.forum.payload.response;

import java.util.Objects;

public class MessagemResponse {

    private String mensagem;

    public MessagemResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "MessagemResponse{" +
                "mensagem='" + mensagem + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessagemResponse that)) return false;
        return mensagem.equals(that.mensagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mensagem);
    }
}
