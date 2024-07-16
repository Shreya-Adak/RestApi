package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.advices;


import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.exceptions.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

//if we want to throw all exception by a class
//like you can say if a put @ExceptionHandler on separately in our every request
//we can make a separate class and all exceptions are thrown by it instead of creating all exception one by one

@RestControllerAdvice
public class GlobalExceptionHandler {


    //we can create our own exception in separate package (exceptions)
    //here you use ResourceNotFound exception instead of NoSuchElementException.....
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiError> handleIdOrResourceNotFound(ResourceNotFound exception){
        ApiError apiError = ApiError
                .builder()
                .status(HttpStatus.NOT_FOUND)
                //.message("Id or Resource not found") // we can getMessage() method here
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
    /*//this method is returning a string
       // but if I want to returning a Object that's why we can create our custom error class (ApiError)
     */
//    public ResponseEntity<String> handleIdOrResourceNotFound(NoSuchElementException exception){
//        return new ResponseEntity<>("Id or Resource not found", HttpStatus.NOT_FOUND);
//    }



    /* You can write any other exceptions here */
}
