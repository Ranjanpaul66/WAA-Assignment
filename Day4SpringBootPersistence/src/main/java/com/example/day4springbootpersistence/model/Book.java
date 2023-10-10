package com.example.day4springbootpersistence.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
//@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int totalPage;
    private int noOfCopies;
    @ManyToOne
    private Publisher publisher;


}
