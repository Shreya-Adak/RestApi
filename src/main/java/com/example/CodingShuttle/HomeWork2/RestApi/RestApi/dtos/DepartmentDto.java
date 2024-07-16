package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;


// Controller -> Dto -> Service
//Presentation Layer
//we have to check 1st the dto is valid or not

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;


   // @NotNull(message = "Required field in department: title") //you have to add @valid annotation when you want to create an department(in controller)
    //if you don't pass title in server body you will get 404 not found error

    //@NotEmpty(message = "Title cannot be empty") // if you want a empty value it will get 400 not found error
    @NotBlank(message = "Title can not be blank") // if you put it blank it will get 400 not found error
    //if not 404 found
    private String title;
    @URL(message = "put valid url")
    private String websites;

    @JsonProperty("isActive")
    @AssertTrue
    private boolean isActive;


    
    @PastOrPresent(message = "put valid create date")
    private LocalDate createdAt;


}
