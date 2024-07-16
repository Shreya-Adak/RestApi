package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.dtos;

import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.annotations.EmployeePasswordValidation;
import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.annotations.EmployeePrimeReferenceCodeValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    @NotEmpty
    @Length(min=3,max=16)
    private String firstName;
    @NotNull
    private String lastName;
    @NotBlank
    @Size(min=3,max=20)
    private String userName;
    @Email
    private String email;
    //@Range(min=18,max=60)
    @Max(value = 60,message = "Age can't be grater than 60")
    @Min(value = 18,message = "Age can't be less than 18")
    private int age;
    @Pattern(regexp = "^(ADMIN|USER)$",message = "The role of employee can be USER or ADMIN")
    private String role;

    //Custom validation entity

    @NotBlank
    @EmployeePasswordValidation
    private String password;

    @Positive
    @Min(value = 2)
    @EmployeePrimeReferenceCodeValidation
    private Long referenceCode;

    //
    @Negative
    private double debt;
    @NegativeOrZero
    private double overDraft;
    @Positive
    @Digits(integer =6,fraction = 2,message = "The salary should be XXXXXX.YY")
    @DecimalMin(value = "10000.00",message = "Salary can't be less than 10000.00")
    @DecimalMax(value = "999999.99",message = "Salary can't be more than 999999.99")
    private double salary;
    @PositiveOrZero
    private double bonusPoint;
    @CreditCardNumber(message = "it start with '4' and have 16 digits")
    //The credit card number "4111111111111111" is commonly used as a test card number
 /*
//Visa: 4111111111111111
//MasterCard: 5555555555554444
//American Express: 378282246310005
//Discover: 6011111111111117
//JCB: 3530111333300000
//Diners Club: 30569309025904
//These numbers will pass validation checks but are not linked to actual accounts and cannot be used for real transactions.
     */

    private String creditCardNo;
    @Past
    private LocalDate dateOfBirth;
    @PastOrPresent
    private LocalDate joiningDate;
    @FutureOrPresent
    private LocalDate taskCompletionDeadLine;
    @Future
    private LocalDate retiredDate;
    @Null
    private String notes;
    @JsonProperty("isActive")
    @AssertTrue
    private boolean isActive;
    @AssertFalse
    private boolean criminalActivity;
    private String Hi;
}
