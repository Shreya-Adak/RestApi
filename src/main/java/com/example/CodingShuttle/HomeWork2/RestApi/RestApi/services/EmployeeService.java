package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.services;

import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.dtos.EmployeeDto;
import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.entities.EmployeeEntity;
import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.exceptions.ResourceNotFound;
import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDto createEmployees(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntitySaved = modelMapper.map(employeeDto,EmployeeEntity.class);
        EmployeeEntity employeeEntity = employeeRepository.save(employeeEntitySaved);
        return modelMapper.map(employeeEntity,EmployeeDto.class);

    }

    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto) {
       isExist((employeeId));
       EmployeeEntity employeeEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
       employeeEntity.setId(employeeId);
       EmployeeEntity employeeEntity1 = employeeRepository.save(employeeEntity);
       return modelMapper.map(employeeEntity1,EmployeeDto.class);

    }


    public boolean deleteAllById(Long id) {
        isExist(id);
        employeeRepository.deleteById(id);
        return true;
    }


    public void isExist(Long Id){
        boolean exist = employeeRepository.existsById(Id);
        if(!exist)throw new ResourceNotFound("Id or Resource not found with Id "+Id);
    }


}
