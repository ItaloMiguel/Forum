package br.com.api.forum.payload.response;

import br.com.api.forum.enums.StatusTopico;
import br.com.api.forum.model.Curso;
import br.com.api.forum.model.Resposta;
import br.com.api.forum.model.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public class TopicosResponseDto {
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private StatusTopico status;
    private Usuario autor;
    private CursoResponseDto cursoResponseDto;
    private List<Resposta> respostas;

    public TopicosResponseDto(String titulo, String mensagem, LocalDateTime dataCriacao, StatusTopico status, Usuario autor, Curso cursoResponseDto, List<Resposta> respostas) {
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
}
