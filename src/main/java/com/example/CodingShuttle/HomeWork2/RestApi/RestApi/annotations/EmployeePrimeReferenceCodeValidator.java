package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeePrimeReferenceCodeValidator  implements ConstraintValidator<EmployeePrimeReferenceCodeValidation,Long> {
    @Override
    public boolean isValid(Long referenceCode, ConstraintValidatorContext constraintValidatorContext) {
        for(int i=2;i<=Math.sqrt(referenceCode);i++){
            if(referenceCode%i==0)return false;
        }
        return true;
    }
}
