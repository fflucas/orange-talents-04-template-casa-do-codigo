package br.com.zupacademy.fabio.casadocodigo.autor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "autor")
public class ModeloAutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(length = 400, nullable = false)
    private String descricao;
    @Column(nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Deprecated
    public ModeloAutor() {
    }

    public ModeloAutor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }
}
