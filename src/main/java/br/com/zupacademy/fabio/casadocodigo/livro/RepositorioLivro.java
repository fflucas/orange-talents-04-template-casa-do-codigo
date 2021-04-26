package br.com.zupacademy.fabio.casadocodigo.livro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioLivro extends JpaRepository<ModeloLivro, Long> {

}
