package br.libdolf.backendlivraria.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CountryMatchesCPFValidator.class)
public @interface CountryMatchesCPF {
    String message() default "O CPF é obrigatório para o Brasil.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
