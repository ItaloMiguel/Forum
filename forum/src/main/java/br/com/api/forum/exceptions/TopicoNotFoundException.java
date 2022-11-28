package br.com.api.forum.exceptions;

public class TopicoNotFoundException extends RuntimeException {

    public TopicoNotFoundException(String message) {
        super("Nao foi possivel achar o topico com esse nome: " + message);
    }
    public TopicoNotFoundException(Long id) {
        super("Nao foi possivel achar o topico com esse id: " + id);
    }
}
