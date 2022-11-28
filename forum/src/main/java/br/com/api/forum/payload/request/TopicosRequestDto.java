package br.com.api.forum.payload.request;

import br.com.api.forum.exceptions.CursoNotFoundException;
import br.com.api.forum.model.Curso;
import br.com.api.forum.model.Topico;
import br.com.api.forum.repository.RepositorioDeCursoH2;

public class TopicosRequestDto {
    private String titulo;
    private String mensagem;
    private String nomeCurso;

    public TopicosRequestDto(String titulo, String mensagem, String nomeCurso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.nomeCurso = nomeCurso;
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

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Topico converter(RepositorioDeCursoH2 repositorioDeCurso) {
        Curso curso = repositorioDeCurso.findByNome(nomeCurso).orElseThrow(() -> new CursoNotFoundException(nomeCurso));
        return new Topico(titulo, mensagem, curso);
    }
}
