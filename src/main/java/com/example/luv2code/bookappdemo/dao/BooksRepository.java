package com.example.luv2code.bookappdemo.dao;

import com.example.luv2code.bookappdemo.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Integer> {
}
