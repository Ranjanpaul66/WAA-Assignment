package com.example.day4springbootpersistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
//@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany
    private List<Course> courses;
}
