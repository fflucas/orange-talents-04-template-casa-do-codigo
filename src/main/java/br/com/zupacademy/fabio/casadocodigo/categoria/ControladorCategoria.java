package br.com.zupacademy.fabio.casadocodigo.categoria;

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

    @Autowired
    public ControladorCategoria(RepositorioCategoria repositorioCategoria) {
        this.repositorioCategoria = repositorioCategoria;
    }

    @PostMapping
    public ResponseEntity<ModeloCategoria> create(@RequestBody @Valid DtoCategoria dtoCategoria){
        ModeloCategoria categoria = dtoCategoria.converteParaCategoria();
        repositorioCategoria.save(categoria);
        return ResponseEntity.ok(categoria);
    }
}
