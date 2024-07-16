package com.example.CodingShuttle.HomeWork2.RestApi.RestApi.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity

//if we don't set this getter setter constructor then we don't get the table....
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Department")  //table name of database

//Repository -> Entity -> Database
//Persistence Layer
//we need Jpa for this we have to add Data jpa dependency
public class DepartmentEntity {
    @Id //id is out primary key
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String title;
    private String websites;
    private boolean isActive;
    private LocalDate createdAt;
}
