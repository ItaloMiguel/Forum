package br.com.api.forum.configuration.validacao;

import java.util.Objects;

public class ErroDeFormularioDto {
    private String campo;
    private String erro;

    public ErroDeFormularioDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }

    @Override
    public String toString() {
        return "ErroDeFormularioDto{" +
                "campo='" + campo + '\'' +
                ", erro='" + erro + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErroDeFormularioDto that)) return false;
        return Objects.equals(campo, that.campo) && Objects.equals(erro, that.erro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campo, erro);
    }
}
