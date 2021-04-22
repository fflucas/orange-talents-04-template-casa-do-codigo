package br.com.zupacademy.fabio.casadocodigo.autor.validador;

import br.com.zupacademy.fabio.casadocodigo.autor.DtoAutor;
import br.com.zupacademy.fabio.casadocodigo.autor.ModeloAutor;
import br.com.zupacademy.fabio.casadocodigo.autor.RepositorioAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicado implements Validator {

    private RepositorioAutor repositorioAutor;
    @Autowired
    public ProibeEmailDuplicado(RepositorioAutor repositorioAutor) {
        this.repositorioAutor = repositorioAutor;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return DtoAutor.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        DtoAutor dtoAutor = (DtoAutor) obj;
        Optional<ModeloAutor> autorByEmail = repositorioAutor.findByEmail(dtoAutor.getEmail());
        if(autorByEmail.isPresent()){
            errors.rejectValue("email", null, "O email "+ dtoAutor.getEmail() +" já existe");
        }
    }
}
