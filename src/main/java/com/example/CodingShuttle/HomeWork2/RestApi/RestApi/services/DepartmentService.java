package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.services;


import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.dtos.DepartmentDto;
import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.entities.DepartmentEntity;
import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.exceptions.ResourceNotFound;
import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// Controller -> Dto -> Service (Presentation)
//Service -> Repository -> Entity -> Database (Persistence)
//Presentation Layer -> Service Layer -> Persistence Layer

//when we are using ResponseEntity you have to make our return type as optional in service
////it is used when we send a request and the Id is not found then it is getting error
@Service
public class DepartmentService {
    
    
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }
//get by id
    //optional
    public Optional<DepartmentDto> departmentById(Long departmentId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        return departmentEntity.map(departmentEntity1 -> modelMapper.map(departmentEntity1,DepartmentDto.class));  //to map between entity and dto
    }


    //get all
    public List<DepartmentDto> allDepartments() {
        List<DepartmentEntity> departmentEntity = departmentRepository.findAll();
        return departmentEntity
                .stream()
                .map(departmentEntity1 -> modelMapper.map(departmentEntity1,DepartmentDto.class))
                .collect(Collectors.toList());

    }
    //post all
    public DepartmentDto createAllDepartment(DepartmentDto inputDepartment) {
        DepartmentEntity saved = modelMapper.map(inputDepartment,DepartmentEntity.class);

        DepartmentEntity departmentEntity = departmentRepository.save(saved);
        return modelMapper.map(departmentEntity,DepartmentDto.class);
    }
    //put by id
    public DepartmentDto updateDepartmentById(Long Id,DepartmentDto departmentDto) {
        //if(!isExist(Id))return null; // we can throw an exception if not found
        isExist(Id);
        DepartmentEntity departmentEntity = modelMapper.map(departmentDto,DepartmentEntity.class);
        departmentEntity.setId(Id);
        DepartmentEntity departmentEntity1 = departmentRepository.save(departmentEntity);
        return modelMapper.map(departmentEntity1,DepartmentDto.class);
    }
    //delete by id
    public boolean deleteByDepartmentId(Long Id) {
        isExist(Id);
        departmentRepository.deleteById(Id);
        return true;

    }

    public void isExist(Long departmentId){

        boolean exist = departmentRepository.existsById(departmentId);
        if(!exist)throw new ResourceNotFound("Id or Resource not found with Id "+departmentId);
    }



}
