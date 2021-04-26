package br.com.zupacademy.fabio.casadocodigo.cliente;

import br.com.zupacademy.fabio.casadocodigo.estado.ModeloEstado;
import br.com.zupacademy.fabio.casadocodigo.pais.ModeloPais;

import javax.persistence.*;

@Entity(name = "cliente")
public class ModeloCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String complemento;
    @Column(nullable = false)
    private String cidade;
    @ManyToOne
    private ModeloPais pais;
    @ManyToOne
    private ModeloEstado estado;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String cep;
    @Deprecated
    public ModeloCliente() {
    }

    public ModeloCliente(String email, String nome, String sobrenome, String cpf, String endereco, String complemento, String cidade,
                         ModeloPais pais, ModeloEstado estado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public ModeloPais getPais() {
        return pais;
    }

    public ModeloEstado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
