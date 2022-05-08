package com.bookstoreapplication.service;

import com.bookstoreapplication.dto.BookDTO;
import com.bookstoreapplication.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * Created IBookService interface to achieve abstraction
 */

public interface IBookService {
    Book createBook(BookDTO bookDTO);

    Optional<Book> getBookDataById(int BookId);

    List<Book> getAllBookData();

    Book updateRecordById(Integer BookId, BookDTO bookDTO);

    Object deleteRecordById(int BookId);

}