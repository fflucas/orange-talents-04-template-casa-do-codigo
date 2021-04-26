package br.com.zupacademy.fabio.casadocodigo.validador;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueStateForCountryValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueStateForCountry {
    String message() default "State must be unique for country";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String columnState();
    String columnCountry();
    Class<?> domainClass();
}
