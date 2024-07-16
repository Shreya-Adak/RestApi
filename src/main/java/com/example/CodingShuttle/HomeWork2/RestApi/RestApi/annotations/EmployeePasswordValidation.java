package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = {EmployeePasswordValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})

public @interface EmployeePasswordValidation {
    String message() default """
            {a.one uppercase letter\s
            b.one lowercase letter\s
            c.one special character\s
            d. minimum length is 10 characters
            }""";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
