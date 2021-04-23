package br.com.zupacademy.fabio.casadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class ControladorLivro {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    public ControladorLivro(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ModeloLivro> create(@RequestBody @Valid DtoLivro dtoLivro){
        ModeloLivro livro = dtoLivro.converteParaLivro(entityManager);
        entityManager.persist(livro);
        return ResponseEntity.ok(livro);
    }

    @GetMapping
    public List listAll(){
        return entityManager.createNativeQuery("SELECT l.id, l.titulo FROM livro l").getResultList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listOne(@PathVariable Long id){
        ModeloLivro modeloLivro = entityManager.find(ModeloLivro.class, id);
        if(modeloLivro == null){
            return ResponseEntity.notFound().build();
        }
        DetalhaLivro livro = new DetalhaLivro(modeloLivro);
        return ResponseEntity.ok(livro);
    }
}
