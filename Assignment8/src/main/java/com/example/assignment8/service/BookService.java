package com.example.assignment8.service;

import com.example.assignment8.domain.Book;

import java.util.List;

public interface BookService {
    public List<Book> getBooks();
    public Book getBook(long id);
    public Book createBook(Book book);

    public Book updateBook(Book book);
    public Boolean deleteBook(Long id);
}
