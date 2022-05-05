package com.bookstoreapplication.service;

import com.bookstoreapplication.dto.BookDTO;
import com.bookstoreapplication.exception.BookStoreException;
import com.bookstoreapplication.model.Book;
import com.bookstoreapplication.repository.BookStoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService implements IBookService{

    @Autowired
    BookStoreRepository bookStoreRepository;

    @Override
    public Book createBook(BookDTO bookDTO) {
        Book newBook = new Book(bookDTO);
        return  bookStoreRepository.save(newBook);

    }

    @Override
    public Optional<Book> getBookDataById(int BookId) {
        Optional<Book> getBook=bookStoreRepository.findById(BookId);
        if(getBook.isPresent()){
            return getBook;

        }
        throw new BookStoreException("Book Store Details for id not found");

    }

    @Override
    public List<Book> getAllBookData() {
        List<Book> getBooks=bookStoreRepository.findAll();
        return getBooks;
    }

    @Override
    public Book updateRecordById(Integer BookId, BookDTO bookDTO) {

        Optional<Book> updateBook = bookStoreRepository.findById(BookId);
        if (updateBook.isPresent()) {
            Book updateUser = new Book(BookId, bookDTO);
            bookStoreRepository.save(updateUser);
            return updateUser;

        } else {

            throw new BookStoreException("Book record does not found");
        }
    }


    @Override
    public String deleteRecordById(int BookId) {
        Optional<Book> newBook = bookStoreRepository.findById(BookId);
        if (newBook.isPresent()) {
            bookStoreRepository.deleteById(BookId);

        } else {
            throw new BookStoreException("Book record does not found");
        }
        return "data deleted succesfull";
    }



}