package br.com.zupacademy.fabio.casadocodigo.livro.estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class ControladorEstado {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    public ControladorEstado(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ModeloEstado> create(@RequestBody @Valid DtoEstado dtoEstado){
        ModeloEstado estado = dtoEstado.converteParaEstado(entityManager);
        entityManager.persist(estado);
        return ResponseEntity.ok(estado);
    }
}
