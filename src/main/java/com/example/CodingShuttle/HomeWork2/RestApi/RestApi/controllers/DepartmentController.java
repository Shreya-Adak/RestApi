package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.controllers;

import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.dtos.DepartmentDto;
import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.entities.DepartmentEntity;
import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.exceptions.ResourceNotFound;
import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.repositories.DepartmentRepository;
import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

// Controller -> Dto -> Service
//Presentation Layer
/*ResponseEntity---- //it is used when we send a request and the Id is not found then it is getting error
//when we want to send a particular status code then we use ResponseEntity<>()....
//is used to represent an HTTP response,
//including the status code(e.g., 200 OK, 201 Created, 404 Not Found), headers, and body.
//It's a more flexible way to create responses compared to returning objects directly from controller methods.

 */

@RestController
@RequestMapping(path="/departments")
public class DepartmentController {


    private final DepartmentService departmentService;   //this is inject by the constructor

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;

    }


    @GetMapping(path = "/{departmentId}")

        public ResponseEntity<DepartmentDto> departmentByTd(@PathVariable(name="departmentId")Long Id){



        Optional<DepartmentDto> departmentDto = departmentService.departmentById(Id);

        return departmentDto
                .map(departmentDto1 ->
                        ResponseEntity.ok(departmentDto1))
                .orElseThrow(()->new ResourceNotFound("Id or Resource not found with Id "+Id));
    }





    @GetMapping

    public ResponseEntity<List<DepartmentDto>> allDepartments(){
        return ResponseEntity.ok(departmentService.allDepartments());

    }

    @PostMapping

    public ResponseEntity<DepartmentDto> createAllDepartment(@RequestBody @Valid DepartmentDto inputDepartment){
        DepartmentDto departmentDtoSaved = departmentService.createAllDepartment(inputDepartment);
        return new ResponseEntity<>(departmentDtoSaved, HttpStatus.CREATED); //we create a table and Httpstatus is a status code
        //it is by default not 200
    }

    @PutMapping(path="/{departmentId}")

    public ResponseEntity<DepartmentDto> updateDepartmentById(@RequestBody @Valid DepartmentDto departmentDto,
                                                              @PathVariable(name="departmentId") Long Id){
        return ResponseEntity.ok(departmentService.updateDepartmentById(Id,departmentDto)); //you can also throw an exception from service
    }


    @DeleteMapping(path="/{departmentId}")

    public ResponseEntity<Boolean> deleteByDepartmentId(@PathVariable(name="departmentId")Long Id){
        if(departmentService.deleteByDepartmentId(Id))return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build(); //you can also throw an exception from service
    }



}























