package br.com.zupacademy.fabio.casadocodigo.categoria.validador;

import br.com.zupacademy.fabio.casadocodigo.categoria.DtoCategoria;
import br.com.zupacademy.fabio.casadocodigo.categoria.ModeloCategoria;
import br.com.zupacademy.fabio.casadocodigo.categoria.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeNomeDuplicado implements Validator {

    private RepositorioCategoria repositorioCategoria;

    @Autowired
    public ProibeNomeDuplicado(RepositorioCategoria repositorioCategoria) {
        this.repositorioCategoria = repositorioCategoria;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return DtoCategoria.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        DtoCategoria categoria = (DtoCategoria) obj;
        String nome = categoria.getNome();
        if(!nome.isBlank()){
            Optional<ModeloCategoria> categoriaByNome = repositorioCategoria.findByNome(nome);
            if(categoriaByNome.isPresent()){
                errors.rejectValue("nome", null, "A categoria " + nome + " já está cadastrada");
            }
        }
    }
}
