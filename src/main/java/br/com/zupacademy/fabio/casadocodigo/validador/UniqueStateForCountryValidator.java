package br.com.zupacademy.fabio.casadocodigo.validador;

import br.com.zupacademy.fabio.casadocodigo.estado.DtoEstado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueStateForCountryValidator implements ConstraintValidator<UniqueStateForCountry, DtoEstado> {

    @PersistenceContext
    private EntityManager entityManager;
    private String columnState;
    private String columnCountry;
    private Class<?> domainClass;

    @Override
    public void initialize(UniqueStateForCountry constraintAnnotation) {
        columnState = constraintAnnotation.columnState();
        columnCountry = constraintAnnotation.columnCountry();
        domainClass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(DtoEstado state, ConstraintValidatorContext constraintValidatorContext) {
        if (state.getNome() == null || state.getId_pais() == null){
            return false;
        }
        Query query = entityManager.createQuery(
                "SELECT 1 FROM "+domainClass.getName()+" WHERE "+columnState+" =: value_nome AND "+columnCountry+" =: value_pais"
        );
        query.setParameter("value_nome", state.getNome());
        query.setParameter("value_pais", state.getId_pais().toString());
        List resultList = query.getResultList();
        return resultList.isEmpty();
    }
}
