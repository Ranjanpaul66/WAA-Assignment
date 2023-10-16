package com.example.assignment8.domain;

import lombok.Data;

import jakarta.persistence.*;
@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String isbn;
    private double price;

}
