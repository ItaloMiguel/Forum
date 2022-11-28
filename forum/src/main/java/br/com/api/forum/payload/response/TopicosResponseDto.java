package br.com.api.forum.payload.response;

import br.com.api.forum.enums.StatusTopico;
import br.com.api.forum.model.Curso;
import br.com.api.forum.model.Resposta;
import br.com.api.forum.model.Usuario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class TopicosResponseDto {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private StatusTopico status;
    private Usuario autor;
    private CursoResponseDto cursoResponseDto;
    private List<Resposta> respostas;

    public TopicosResponseDto(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, StatusTopico status, Usuario autor, Curso cursoResponseDto, List<Resposta> respostas) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.autor = autor;
        this.cursoResponseDto = new CursoResponseDto(cursoResponseDto.getNome(), cursoResponseDto.getCategoria());
        this.respostas = respostas;
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

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public void setStatus(StatusTopico status) {
        this.status = status;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public CursoResponseDto getCursoResponseDto() {
        return cursoResponseDto;
    }

    public void setCursoResponseDto(CursoResponseDto cursoResponseDto) {
        this.cursoResponseDto = cursoResponseDto;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TopicosResponseDto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", status=" + status +
                ", autor=" + autor +
                ", cursoResponseDto=" + cursoResponseDto +
                ", respostas=" + respostas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TopicosResponseDto that)) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
