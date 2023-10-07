package com.example.assignment4.model;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;
    private String name;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}

