package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.controllers;


import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.dtos.EmployeeDto;
import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
      return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployees(@RequestBody @Valid EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.createEmployees(employeeDto);
        return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@RequestBody @Valid EmployeeDto employeeDto,
                                                          @PathVariable Long employeeId) {

        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDto));
    }

//    @DeleteMapping("/{employeeId}")
//    public ResponseEntity<Boolean> deleteAllById(@PathVariable(name = "employeeId") Long id){
//        if(employeeService.deleteAllById(id))return ResponseEntity.ok(true);
//        return ResponseEntity.notFound().build();
//    }
@DeleteMapping("/{employeeId}")
public ResponseEntity<String> deleteAllById(@PathVariable(name = "employeeId") Long id){
    if(employeeService.deleteAllById(id))return ResponseEntity.ok("True");
    return ResponseEntity.notFound().build();
}
}
