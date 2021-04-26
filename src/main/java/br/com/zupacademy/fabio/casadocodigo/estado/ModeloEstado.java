package br.com.zupacademy.fabio.casadocodigo.estado;

import br.com.zupacademy.fabio.casadocodigo.pais.ModeloPais;

import javax.persistence.*;

@Entity(name = "estado")
public class ModeloEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @ManyToOne
    private ModeloPais pais;

    @Deprecated
    public ModeloEstado() {
    }

    public ModeloEstado(String nome, ModeloPais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public ModeloPais getPais() {
        return pais;
    }
}
