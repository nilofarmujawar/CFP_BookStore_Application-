package com.bookstoreapplication.repository;

import com.bookstoreapplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookStoreRepository extends JpaRepository<Book,Integer> {

}