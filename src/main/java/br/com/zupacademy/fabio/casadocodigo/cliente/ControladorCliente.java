package br.com.zupacademy.fabio.casadocodigo.cliente;

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
@RequestMapping("/cliente")
public class ControladorCliente {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    public ControladorCliente(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ModeloCliente> create(@RequestBody @Valid DtoCliente dtoCliente){
        ModeloCliente cliente = dtoCliente.converteParaCliente(entityManager);
        entityManager.persist(cliente);
        return ResponseEntity.ok(cliente);
    }
}
