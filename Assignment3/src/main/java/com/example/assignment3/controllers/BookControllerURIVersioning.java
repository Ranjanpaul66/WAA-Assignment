package com.example.assignment3.controllers;

import com.example.assignment3.models.Book;
import com.example.assignment3.models.Book2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookControllerURIVersioning {
    List<Book> bookList = new ArrayList<>();
    List<Book2> bookList2 = new ArrayList<>();

    @GetMapping("/v1/books")
    public List<Book> getProducts() {
        Book book1 = Book.builder().isvn(1001).edition("2nd Edition").title("Trust your Self").author("Ranjan Paul").build();
        Book book2 = Book.builder().isvn(1002).edition("3rd Edition").title("See your self in Mirror").author("Ranjan Paul").build();
        Book book3 = Book.builder().isvn(1001).edition("5th Edition").title("Mirror Teals you who are you.").author("Ranjan Paul").build();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        return bookList;
    }

    @GetMapping("/v2/books")
    public List<Book2> getProducts2() {
        Book2 book1 = Book2.builder().isvn(1001).edition("2nd Edition").title("Trust your Self").author("Ranjan Paul").build();
        Book2 book2 = Book2.builder().isvn(1002).edition("3rd Edition").title("See your self in Mirror").author("Ranjan Paul").build();
        Book2 book3 = Book2.builder().isvn(1001).edition("5th Edition").title("Mirror Teals you who are you.").author("Ranjan Paul").build();
        bookList2.add(book1);
        bookList2.add(book2);
        bookList2.add(book3);

        return bookList2;
    }
}
