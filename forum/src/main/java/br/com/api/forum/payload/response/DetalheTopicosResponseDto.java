package br.com.api.forum.payload.response;

import br.com.api.forum.enums.StatusTopico;
import br.com.api.forum.model.Curso;
import br.com.api.forum.model.Resposta;
import br.com.api.forum.model.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class DetalheTopicosResponseDto {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private StatusTopico status;
    private String nomeAutor;
    private CursoResponseDto cursoResponseDto;
    private List<Resposta> respostas;

    public DetalheTopicosResponseDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.status = topico.getStatus();
        this.nomeAutor = topico.getAutor().getNome();
        this.cursoResponseDto = new CursoResponseDto(topico.getCurso());
        this.respostas = topico.getRespostas();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public String getAutor() {
        return nomeAutor;
    }

    public CursoResponseDto getCursoResponseDto() {
        return cursoResponseDto;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DetalheTopicosResponseDto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", status=" + status +
                ", autor=" + nomeAutor +
                ", cursoResponseDto=" + cursoResponseDto +
                ", respostas=" + respostas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalheTopicosResponseDto that)) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
