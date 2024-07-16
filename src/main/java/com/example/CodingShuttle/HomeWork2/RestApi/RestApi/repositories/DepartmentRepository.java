package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.repositories;

import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository -> Entity -> Database
//Persistence Layer
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> { //in jpaRepository we have to use Table entity name and the primary key
}
