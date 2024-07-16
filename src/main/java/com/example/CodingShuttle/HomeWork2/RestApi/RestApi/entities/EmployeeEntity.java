package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private int age;
    private String password;
    private String role;
    private Long referenceCode;

    private double debt;
    private double overDraft;
    private double salary;
    private double bonusPoint;

    private String creditCardNo;//The credit card number "4111111111111111" is commonly used as a test card number
    /*
Visa: 4111111111111111
MasterCard: 5555555555554444
American Express: 378282246310005
Discover: 6011111111111117
JCB: 3530111333300000
Diners Club: 30569309025904
These numbers will pass validation checks but are not linked to actual accounts and cannot be used for real transactions.
     */
    private LocalDate dateOfBirth;
    private LocalDate joiningDate;
    private LocalDate taskCompletionDeadLine;
    private LocalDate retiredDate;

    private String notes;
    private boolean isActive;
    private boolean criminalActivity;
    private String Hi;




}
