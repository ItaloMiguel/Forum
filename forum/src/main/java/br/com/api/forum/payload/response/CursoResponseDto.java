package br.com.api.forum.payload.response;

import java.util.Objects;

public class CursoResponseDto {
    private String nome;
    private String categoria;

    public CursoResponseDto(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "CursoResponseDto{" +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CursoResponseDto that)) return false;
        return nome.equals(that.nome) && categoria.equals(that.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, categoria);
    }
}
