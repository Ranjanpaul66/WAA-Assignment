package com.example.assignment1.controllers;

import com.example.assignment1.models.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @GetMapping("/books")
    public Book[] books(){
        Book book = new Book(1,"Book 1", "Ranjan", "1215");
        Book book2 = new Book(2,"Book 2", "Paul", "1216");
        Book book3 = new Book(3,"Book 2", "Mithun", "1216");
        Book[] books = {book, book2, book3};

        return books;
    }
}
