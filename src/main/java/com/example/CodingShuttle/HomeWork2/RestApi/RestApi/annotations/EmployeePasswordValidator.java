package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class EmployeePasswordValidator implements
        ConstraintValidator<EmployeePasswordValidation,String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if(password.length()>=10) {
            int i=0;
            boolean u = false,
                    l = false,
                    s = false;
            while(i < password.length()){
                if(isUpperCase(password.charAt(i))){
                    u=true;
                }
                else if(isLowerCase(password.charAt(i))){
                    l=true;
                }
                else if(isSpecialCharacter(password.charAt(i))){
                    s=true;
                }
                i++;
            }
            return (u&&l&&s);
        };
        return false;
    }
    public boolean isSpecialCharacter(char c){
        char[] specialChar = {'!','"', '#', '$', '%', '&', '(', ')','*', '+', ',', '-','.','/',
                ':', ';', '<', '=', '>', '?', '@', '[', ']', '^', '_', '{', '|', '}', '~','`'};
        for(char ch:specialChar){
            if(ch == c)return true;
        }
        return false;
    }
}
