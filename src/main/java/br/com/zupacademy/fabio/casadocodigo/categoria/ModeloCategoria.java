package br.com.zupacademy.fabio.casadocodigo.categoria;

import javax.persistence.*;

@Entity(name = "categoria")
public class ModeloCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;

    @Deprecated
    public ModeloCategoria() {
    }

    public ModeloCategoria(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
