package com.example.assignment1.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Book {
    private int id;
    private String Title;
    private String Author;
    private String isbn;

}