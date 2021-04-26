package br.com.zupacademy.fabio.casadocodigo.livro.pais;

import javax.persistence.*;

@Entity(name = "pais")
public class ModeloPais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nome;

    @Deprecated
    public ModeloPais() {
    }

    public ModeloPais(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
