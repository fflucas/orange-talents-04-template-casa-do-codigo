package br.com.zupacademy.fabio.casadocodigo.autor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAutor extends CrudRepository<ModeloAutor, Long> {

}
