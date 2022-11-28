package br.com.api.forum.model;

import br.com.api.forum.enums.StatusTopico;
import br.com.api.forum.exceptions.CursoNotFoundException;
import br.com.api.forum.payload.request.TopicosRequestDto;
import br.com.api.forum.repository.RepositorioDeCursoH2;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    @Enumerated(EnumType.STRING)
    private StatusTopico status;
    @ManyToOne
    private Usuario autor;
    @ManyToOne
    private Curso curso;
    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas = new ArrayList<>();

    public Topico() {
    }

    public Topico(String titulo, String mensagem, Curso curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.curso = curso;
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusTopico.NAO_SOLUCIONADO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "Topico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", status=" + status +
                ", autor=" + autor +
                ", curso=" + curso +
                ", respostas=" + respostas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Topico topico)) return false;
        return id.equals(topico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Topico atualizar(TopicosRequestDto requestDto, RepositorioDeCursoH2 repositorioDeCurso) {
        this.curso = repositorioDeCurso.findByNome(requestDto.getNomeCurso())
                .orElseThrow(() -> new CursoNotFoundException(requestDto.getNomeCurso()));
        this.mensagem = requestDto.getMensagem();
        this.titulo = requestDto.getTitulo();
        this.dataAtualizacao = LocalDateTime.now();
        return this;
    }
}
