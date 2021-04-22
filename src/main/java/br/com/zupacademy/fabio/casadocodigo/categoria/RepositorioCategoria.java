package br.com.zupacademy.fabio.casadocodigo.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioCategoria extends JpaRepository<ModeloCategoria, Long> {
    Optional<ModeloCategoria> findByNome(String nome);
}
