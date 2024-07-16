package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = {EmployeePrimeReferenceCodeValidator.class})
public @interface EmployeePrimeReferenceCodeValidation {
    String message() default "{ReferenceCode should be prime number}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
