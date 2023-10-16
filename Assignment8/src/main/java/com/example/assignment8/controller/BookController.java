package com.example.assignment8.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.assignment8.domain.Book;
import com.example.assignment8.domain.User;
import com.example.assignment8.service.BookService;

import java.util.List;

/*
Create a Spring Boot Web Project with following features

1. Create a UserController which can register a new User with email, password, roles

2. Create a BookController which has CRUD operations

3. Add Spring security features below:

3. 1 All authenticated users can get books

3.2 Only Admin can update, delete, create a new Book

3.3 all users(unauthenticated, authenticated) can register new user


 */
@RestController
@Slf4j
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<?> getBooks()
    {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<?>  getBooks(@PathVariable("id") Long id)
    {
        System.out.println("Running...");
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Book bookDTO) {
        Book result = null;
        try {
            result = bookService.createBook(bookDTO);
        } catch(Exception ex) {
            log.error(ex.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Book bookDTO) {
        Book result = null;
        try {
            result = bookService.updateBook(bookDTO);
        } catch(Exception ex) {
            log.error(ex.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
