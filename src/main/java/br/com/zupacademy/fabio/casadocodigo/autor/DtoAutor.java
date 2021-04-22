package br.com.zupacademy.fabio.casadocodigo.autor;

import br.com.zupacademy.fabio.casadocodigo.validador.IsUnique;

import javax.validation.constraints.*;

public class DtoAutor {
    @NotNull @NotBlank
    private String nome;
    @Email @NotBlank @NotNull @IsUnique(domainClass = ModeloAutor.class, fieldName = "email")
    private String email;
    @NotNull @NotBlank @Size(max=400)
    private String descricao;

    public DtoAutor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public ModeloAutor converteParaAutor(){
        return new ModeloAutor(this.nome, this.email, this.descricao);
    }
}
