package com.example.assignment8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.assignment8.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
