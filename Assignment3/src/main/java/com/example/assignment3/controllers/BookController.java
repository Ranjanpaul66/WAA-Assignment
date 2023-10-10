package com.example.assignment3.controllers;

import com.example.assignment3.models.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    List<Book> bookList = new ArrayList<>();


    @GetMapping("")
    public List<Book> getBookList(){

        Book book1 = Book.builder().isvn(1001).edition("2nd Edition").title("Trust your Self").author("Ranjan Paul").build();
        Book book2 = Book.builder().isvn(1002).edition("3rd Edition").title("See your self in Mirror").author("Ranjan Paul").build();
        Book book3 = Book.builder().isvn(1001).edition("5th Edition").title("Mirror Teals you who are you.").author("Ranjan Paul").build();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        return bookList;
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) throws Exception{
        Optional<Book> book = bookList.stream().filter(obj-> obj.getIsvn()==id).findFirst();

        if(book.isPresent()) {
            return book.get();
        } else {
            throw new Exception("Not Found");
        }
    }


    @PostMapping("")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void saveBook() throws Exception{
        Book newBook = Book.builder().title("C++ for everyone").isvn(1004).author("Ranjan Paul").edition("4th Edition").build();
        List<Book> books = bookList;
        books.add(newBook);
    }

    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable int isbn){
        System.out.println("id: "+ isbn );
        bookList = bookList.stream().filter(book -> book.getIsvn()!=isbn).collect(Collectors.toList());
        System.out.printf("book list : "+ bookList);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable int id, @RequestBody Book bookReq) throws Exception {
        Optional<Book> book1 =  bookList
                .stream()
                .filter(p -> p.getIsvn() == id)
                .findFirst();
        if(book1.isPresent()) {
            var old = book1.get();
            old.setTitle(bookReq.getTitle());
            old.setAuthor(bookReq.getAuthor());
            old.setIsvn(bookReq.getIsvn());
//            System.out.println("update : "+ old);
//            System.out.println("list : "+ bookList);
        } else {
            throw new Exception("Not Found");
        }
    }



}
