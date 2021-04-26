package br.com.zupacademy.fabio.casadocodigo.livro.estado;

import br.com.zupacademy.fabio.casadocodigo.livro.pais.ModeloPais;
import br.com.zupacademy.fabio.casadocodigo.validador.Exists;
import br.com.zupacademy.fabio.casadocodigo.validador.UniqueStateForCountry;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

@UniqueStateForCountry(domainClass = ModeloEstado.class, columnCountry = "pais_id", columnState = "nome")
public class DtoEstado {
    @Exists(domainClass = ModeloPais.class, fieldName = "id")
    private Long id_pais;
    @NotBlank
    private String nome;

    @Deprecated
    public DtoEstado() {
    }

    public DtoEstado(String nome, Long id_pais) {
        this.nome = nome;
        this.id_pais = id_pais;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId_pais(Long id_pais) {
        this.id_pais = id_pais;
    }

    public Long getId_pais() {
        return id_pais;
    }

    public String getNome() {
        return nome;
    }

    public ModeloEstado converteParaEstado(EntityManager em){
        ModeloPais pais = em.find(ModeloPais.class, this.id_pais);
        return new ModeloEstado(this.nome, pais);
    }
}
