package com.example.assignment8.service;

import org.springframework.stereotype.Component;
import com.example.assignment8.domain.Book;
import com.example.assignment8.repository.BookRepository;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(long id) {

        return bookRepository.findById(id).get();
    }

    @Override
    public Book createBook(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        Book bookExisting = getBook(book.getId());
        if (bookExisting != null) {
            bookExisting.setIsbn(book.getIsbn());
            bookExisting.setPrice(book.getPrice());
            bookExisting.setTitle(book.getTitle());
            return bookRepository.save(bookExisting);
        } else {
            return bookRepository.save(book);
        }
    }

    @Override
    public Boolean deleteBook(Long id) {
        Book bookExisting = getBook(id);
        if (bookExisting != null) {
            bookRepository.delete(bookExisting);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
