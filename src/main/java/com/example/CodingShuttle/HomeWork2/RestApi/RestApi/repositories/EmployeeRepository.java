package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.repositories;

import com.example.CodingShuttle.HomeWork2.RestApi.RestApi.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
