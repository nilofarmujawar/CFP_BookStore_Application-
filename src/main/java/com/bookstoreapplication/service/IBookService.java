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

    Book getBookDataById(int BookId);

    List<Book> getAllBookData();

    Book updateRecordById(Integer BookId, BookDTO bookDTO);

    Object deleteRecordById(int BookId);

    List<Book> getBookByName(String bookName);

    List<Book> sortedListOfBooksInAscendingOrder();

    List<Book> sortedListOfBooksInDescendingOrder();

    List<Book> getBookByAuthorName(String authorName);

}