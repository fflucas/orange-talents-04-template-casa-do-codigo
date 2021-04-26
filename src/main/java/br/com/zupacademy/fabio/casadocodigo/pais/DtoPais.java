package br.com.zupacademy.fabio.casadocodigo.livro.pais;

import br.com.zupacademy.fabio.casadocodigo.validador.IsUnique;

import javax.validation.constraints.NotBlank;

public class DtoPais {

    @NotBlank @IsUnique(domainClass = ModeloPais.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public DtoPais() {
    }

    public DtoPais(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ModeloPais converteParaPais(){
        return new ModeloPais(nome);
    }
}
