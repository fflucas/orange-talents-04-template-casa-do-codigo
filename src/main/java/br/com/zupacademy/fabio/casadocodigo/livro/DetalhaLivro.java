package br.com.zupacademy.fabio.casadocodigo.livro;

import br.com.zupacademy.fabio.casadocodigo.autor.ModeloAutor;
import br.com.zupacademy.fabio.casadocodigo.categoria.ModeloCategoria;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalhaLivro {
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int numPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private ModeloAutor autor;
    private ModeloCategoria categoria;

    public DetalhaLivro(ModeloLivro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numPaginas = livro.getNumPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autor = livro.getAutor();
        this.categoria = livro.getCategoria();
    }

    public ModeloAutor getAutor() {
        return autor;
    }

    public ModeloCategoria getCategoria() {
        return categoria;
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

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }
}
