package br.com.zupacademy.fabio.casadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class ControladorLivro {

    @PersistenceContext
    private EntityManager entityManager;
    private RepositorioLivro repositorioLivro;
    @Autowired
    public ControladorLivro(EntityManager entityManager, RepositorioLivro repositorioLivro) {
        this.entityManager = entityManager;
        this.repositorioLivro = repositorioLivro;
    }

    @PostMapping
    public ResponseEntity<ModeloLivro> create(@RequestBody @Valid DtoLivro dtoLivro){
        ModeloLivro livro = dtoLivro.converteParaLivro(entityManager);
        repositorioLivro.save(livro);
        return ResponseEntity.ok(livro);
    }
}
