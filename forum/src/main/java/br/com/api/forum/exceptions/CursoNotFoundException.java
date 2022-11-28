package br.com.api.forum.exceptions;

import br.com.api.forum.model.Curso;

public class CursoNotFoundException extends RuntimeException {

    public CursoNotFoundException(String curso) {
        super("Curso com esse nome: " + curso + " não foi achado no banco de dados");
    }
}
