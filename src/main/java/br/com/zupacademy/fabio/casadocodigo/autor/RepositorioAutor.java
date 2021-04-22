package br.com.zupacademy.fabio.casadocodigo.autor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioAutor extends CrudRepository<ModeloAutor, Long> {
    Optional<ModeloAutor> findByEmail(String email);
}
