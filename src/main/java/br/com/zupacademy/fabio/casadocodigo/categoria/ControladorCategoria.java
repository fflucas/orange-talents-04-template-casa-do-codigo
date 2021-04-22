package br.com.zupacademy.fabio.casadocodigo.categoria;

import br.com.zupacademy.fabio.casadocodigo.categoria.validador.ProibeNomeDuplicado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class ControladorCategoria {

    private RepositorioCategoria repositorioCategoria;
    private ProibeNomeDuplicado proibeNomeDuplicado;

    @Autowired
    public ControladorCategoria(RepositorioCategoria repositorioCategoria, ProibeNomeDuplicado proibeNomeDuplicado) {
        this.repositorioCategoria = repositorioCategoria;
        this.proibeNomeDuplicado = proibeNomeDuplicado;
    }

    @PostMapping
    public ResponseEntity<ModeloCategoria> create(@RequestBody @Valid DtoCategoria dtoCategoria){
        ModeloCategoria categoria = dtoCategoria.converteParaCategoria();
        repositorioCategoria.save(categoria);
        return ResponseEntity.ok(categoria);
    }
}
