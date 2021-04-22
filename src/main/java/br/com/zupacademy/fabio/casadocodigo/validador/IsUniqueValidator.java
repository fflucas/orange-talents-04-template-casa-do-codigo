package br.com.zupacademy.fabio.casadocodigo.validador;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class IsUniqueValidator implements ConstraintValidator<IsUnique, Object> {

    @PersistenceContext
    private EntityManager entityManager;
    private String columnAttribute;
    private Class<?> entityClass;

    @Override
    public void initialize(IsUnique constraintAnnotation) {
        entityClass = constraintAnnotation.domainClass();
        columnAttribute = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery(
                "SELECT 1 FROM "+entityClass.getName()+" WHERE "+columnAttribute+" =: value"
        );
        query.setParameter("value", value);
        List resultList = query.getResultList();
        return resultList.isEmpty();
    }
}
