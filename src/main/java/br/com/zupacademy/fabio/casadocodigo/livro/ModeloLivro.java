package br.com.zupacademy.fabio.casadocodigo.livro;

import br.com.zupacademy.fabio.casadocodigo.autor.ModeloAutor;
import br.com.zupacademy.fabio.casadocodigo.categoria.ModeloCategoria;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "livro")
public class ModeloLivro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String titulo;
    @Column(nullable = false, length = 500)
    private String resumo;
    @Lob
    @Column(columnDefinition = "text")
    private String sumario;
    @Column(nullable = false)
    private BigDecimal preco;
    @Column(nullable = false)
    private int numPaginas;
    @Column(unique = true, nullable = false)
    private String isbn;
    private LocalDate dataPublicacao;
    @ManyToOne
    private ModeloCategoria categoria;
    @ManyToOne
    private ModeloAutor autor;

    public ModeloLivro(String titulo, String resumo,
                       String sumario, BigDecimal preco, int numPaginas, String isbn,
                       LocalDate dataPublicacao, ModeloCategoria categoria,
                       ModeloAutor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Deprecated
    public ModeloLivro() {
    }

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public ModeloCategoria getCategoria() {
        return categoria;
    }

    public ModeloAutor getAutor() {
        return autor;
    }
}
