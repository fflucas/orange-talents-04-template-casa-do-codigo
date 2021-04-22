package br.com.zupacademy.fabio.casadocodigo.autor;

import br.com.zupacademy.fabio.casadocodigo.autor.validador.ProibeEmailDuplicado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class ControladorAutor {

    private RepositorioAutor repositorioAutor;
    private ProibeEmailDuplicado proibeEmailDuplicado;
    @Autowired
    public ControladorAutor(RepositorioAutor repositorioAutor, ProibeEmailDuplicado proibeEmailDuplicado) {
        this.repositorioAutor = repositorioAutor;
        this.proibeEmailDuplicado = proibeEmailDuplicado;
    }

    @PostMapping
    public ResponseEntity<ModeloAutor> create(@RequestBody @Valid DtoAutor dtoAutor){
        ModeloAutor autor = dtoAutor.converteParaAutor();
        repositorioAutor.save(autor);
        return ResponseEntity.ok(autor);
    }
}
