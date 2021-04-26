package br.com.zupacademy.fabio.casadocodigo.cliente;

import br.com.zupacademy.fabio.casadocodigo.estado.ModeloEstado;
import br.com.zupacademy.fabio.casadocodigo.pais.ModeloPais;
import br.com.zupacademy.fabio.casadocodigo.validador.Exists;
import br.com.zupacademy.fabio.casadocodigo.validador.IsUnique;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class DtoCliente {
    @NotBlank @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank @IsUnique(domainClass = ModeloCliente.class, fieldName = "cpf")
    private String cpf;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @Exists(domainClass = ModeloPais.class, fieldName = "id")
    private Long pais_id;
    @Exists(domainClass = ModeloEstado.class, fieldName = "id")
    private Long estado_id;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    @Deprecated
    public DtoCliente() {
    }

    public DtoCliente(String email, String nome, String sobrenome, String cpf, String endereco, String complemento,
                      String cidade, Long pais_id, Long estado_id, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais_id = pais_id;
        this.estado_id = estado_id;
        this.telefone = telefone;
        this.cep = cep;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setPais_id(Long pais_id) {
        this.pais_id = pais_id;
    }

    public void setEstado_id(Long estado_id) {
        this.estado_id = estado_id;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public ModeloCliente converteParaCliente(EntityManager em){
        ModeloPais pais = em.find(ModeloPais.class, this.pais_id);
        ModeloEstado estado = em.find(ModeloEstado.class, this.estado_id);
        return new ModeloCliente(email,nome,sobrenome,cpf,endereco,complemento,cidade,pais,estado,telefone,cep);
    }
}
