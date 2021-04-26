package br.com.zupacademy.fabio.casadocodigo.livro.pais;

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
@RequestMapping("/pais")
public class ControladorPais {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    public ControladorPais(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ModeloPais> create(@RequestBody @Valid DtoPais dtoPais){
        ModeloPais pais = dtoPais.converteParaPais();
        entityManager.persist(pais);
        return ResponseEntity.ok(pais);
    }

}
