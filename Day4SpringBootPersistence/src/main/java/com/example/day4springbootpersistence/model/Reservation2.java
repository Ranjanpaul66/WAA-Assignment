package com.example.day4springbootpersistence.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
//@Entity
public class Reservation2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book2 book;



}
