package br.com.api.forum.exceptions;

public class CursoNotFoundException extends RuntimeException {
    public CursoNotFoundException(String message) {
        super("Curso não foi achado com esse nome: " + message);
    }
}
