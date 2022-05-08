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

/**
 * Created BookService class to serve api calls done by controller layer
 */
public class BookService implements IBookService{

    /**
     * Autowired BookStoreRepository interface to inject its dependency here
     */
    @Autowired
    BookStoreRepository bookStoreRepository;

    /**
     * create a method name as createBook
     * Ability to save book details to repository
     * @param bookDTO - all book data
     * @return - save all data
     */
    @Override
    public Book createBook(BookDTO bookDTO) {
        Book newBook = new Book(bookDTO);
        return  bookStoreRepository.save(newBook);
    }

    /**
     * create a method name as getBookDataById
     * - Ability to get book data by id
     * @param BookId - book id
     * @return - book data by id
     */
    @Override
    public Optional<Book> getBookDataById(int BookId) {
        Optional<Book> getBook=bookStoreRepository.findById(BookId);
        if(getBook.isPresent()){
            return getBook;

        }
        throw new BookStoreException("Book Store Details for id not found");

    }

    /**
     * create a method name as getAllData
     * - Ability to get all book' data by findAll() method
     * @return - all data
     */
    @Override
    public List<Book> getAllBookData() {
        List<Book> getBooks=bookStoreRepository.findAll();
        return getBooks;
    }

    /**
     * create a method name as updateRecordById
     * Ability to update book data for particular id
     * @param BookId - book id
     * @param bookDTO - book data
     * @return - updated book information in JSON format
     */
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

    /**
     * create a method name as deleteRecordById
     * ability to delete data by particular book id
     * @param BookId - book id
     * @return - bookId and Acknowledgment message
     */
    @Override
    public String deleteRecordById(int BookId) {
        Optional<Book> newBook = bookStoreRepository.findById(BookId);
        if (newBook.isPresent()) {
            bookStoreRepository.deleteById(BookId);

        } else {
            throw new BookStoreException("Book record does not found");
        }
        return "data deleted successful";
    }

}