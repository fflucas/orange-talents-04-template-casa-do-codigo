package br.com.zupacademy.fabio.casadocodigo.autor;

import br.com.zupacademy.fabio.casadocodigo.validador.ProibeEmailDuplicado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/autor")
public class ControladorAutor {

    private RepositorioAutor repositorioAutor;
    private ProibeEmailDuplicado proibeEmailDuplicado;
    @Autowired
    public ControladorAutor(RepositorioAutor repositorioAutor, ProibeEmailDuplicado proibeEmailDuplicado) {
        this.repositorioAutor = repositorioAutor;
        this.proibeEmailDuplicado = proibeEmailDuplicado;
    }

    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.addValidators(this.proibeEmailDuplicado);
    }

    @PostMapping
    public ResponseEntity<ModeloAutor> create(@RequestBody @Valid DtoAutor dtoAutor){
        System.out.println(LocalDateTime.now());
        ModeloAutor autor = dtoAutor.converteParaAutor();
        repositorioAutor.save(autor);
        return ResponseEntity.ok(autor);
    }
}