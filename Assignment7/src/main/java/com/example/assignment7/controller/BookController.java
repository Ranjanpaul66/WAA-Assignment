package com.example.assignment7.controller;

import com.example.assignment7.exception.BookNotFoundException;
import com.example.assignment7.model.Book;
import com.example.assignment7.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("{bookId}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long bookId) {
        Book b = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("No book Found!"));
        if (!bookId.equals(b.getId())) {
            throw new BookNotFoundException("No book Found!");
        }
        return bookRepository.save(book);
    }

    @DeleteMapping("{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long bookId) {
        bookRepository.deleteById(bookId);
    }

}
