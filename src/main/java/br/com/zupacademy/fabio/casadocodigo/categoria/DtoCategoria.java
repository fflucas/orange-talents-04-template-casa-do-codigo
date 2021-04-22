package br.com.zupacademy.fabio.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DtoCategoria {
    @NotNull @NotBlank
    private String nome;

    @Deprecated
    public DtoCategoria() {
    }

    public ModeloCategoria converteParaCategoria(){
        return new ModeloCategoria(this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}