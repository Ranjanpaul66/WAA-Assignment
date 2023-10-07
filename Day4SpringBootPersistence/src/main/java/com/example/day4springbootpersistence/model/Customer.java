package com.example.day4springbootpersistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
//@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;

}
