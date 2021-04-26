package br.com.zupacademy.fabio.casadocodigo.livro;

import br.com.zupacademy.fabio.casadocodigo.autor.ModeloAutor;
import br.com.zupacademy.fabio.casadocodigo.categoria.ModeloCategoria;
import br.com.zupacademy.fabio.casadocodigo.validador.Exists;
import br.com.zupacademy.fabio.casadocodigo.validador.IsUnique;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DtoLivro {
    @NotBlank @IsUnique(domainClass = ModeloLivro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank @Size(max = 500)
    private String resumo;
    private String sumario;
    @DecimalMin(value = "20")
    private BigDecimal preco;
    @Min(100)
    private int numPaginas;
    @NotBlank @IsUnique(domainClass = ModeloLivro.class, fieldName = "isbn")
    private String isbn;
    @Future
    private LocalDate dataPublicacao;
    @Exists(domainClass = ModeloCategoria.class, fieldName = "id")
    private Long id_categoria;
    @Exists(domainClass = ModeloAutor.class, fieldName = "id")
    private Long id_autor;

    @Deprecated
    public DtoLivro() {
    }

    public ModeloLivro converteParaLivro(EntityManager entityManager){
        ModeloAutor autor = entityManager.find(ModeloAutor.class, this.id_autor);
        ModeloCategoria categoria = entityManager.find(ModeloCategoria.class, this.id_categoria);
        return new ModeloLivro(
                this.titulo, this.resumo, this.sumario,
                this.preco, this.numPaginas, this.isbn, this.dataPublicacao,
                categoria, autor
        );
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setId_autor(Long id_autor) {
        this.id_autor = id_autor;
    }
}
