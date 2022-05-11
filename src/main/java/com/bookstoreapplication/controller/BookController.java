package com.bookstoreapplication.controller;
import com.bookstoreapplication.dto.BookDTO;
import com.bookstoreapplication.dto.ResponseDTO;
import com.bookstoreapplication.model.Book;
import com.bookstoreapplication.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 *  1) @RestController :-
 *           @RestController is used for making restful web services with the help of the @RestController annotation.
 *           This annotation is used at the class level and allows the class to handle the requests made by the client
 * 2) @RequestMapping :-
 *           @RequestMapping used to map web requests onto specific handler classes and/or handler methods.
 *           RequestMapping can be applied to the controller class as well as methods
 *
 * - Created controller so that we can perform rest api calls
 */
@RestController
@RequestMapping("/book")

public class BookController {

    /**
     * 3) @AutoMapping :-
     *          @Autowiring feature of spring framework enables you to inject the object dependency implicitly.
     *          It internally uses setter or constructor injection.
     *
     * - Autowired IBookService interface so we can inject its dependency here
     */
    @Autowired
    IBookService bookService;

    /**
     * 4) @PostMapping :-
     *           @PostMapping annotation maps HTTP POST requests onto specific handler methods.
     *           It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod. POST)
     *
     * 5) @RequestBody :-
     *            @RequestBody annotation is applicable to handler methods of Spring controllers.
     *            This annotation indicates that Spring should deserialize a request body into an object.
     *            This object is passed as a handler method parameter
     *
     * - Ability to save book details to repository
     * @apiNote- accepts the book data in JSON format and stores it in DB
     * @param bookDTO - book data
     * @return :- responseDTO
     */
//response entity ka object return kar rhe hai o string type ka hoga
    @PostMapping("/insert")
    public ResponseEntity<String> addBookToRepository(@Valid @RequestBody BookDTO bookDTO){
        Book newBook= bookService.createBook(bookDTO);
        ResponseDTO responseDTO=new ResponseDTO("New Book Added in Book Store",newBook);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    /**
     * - Ability to get all book' data by findAll() method
     * @return :- showing all data
     */
    @GetMapping(value = "/getAll")
    public ResponseEntity<String> getAllBookData() {
        List<Book> listOfBooks = bookService.getAllBookData();
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:",listOfBooks);
        return new ResponseEntity(dto,HttpStatus.OK);
    }


    /**
     * 6) @PathVariable :-
     *           @PathVariable is a Spring annotation which indicates that a method parameter should be bound to a URI template variable. It has the following optional elements: name - name of the path variable to bind to.
     *           required - tells whether the path variable is required.
     * - Ability to get book data by id
     * @param BookId - book id
     * @return -book information with same bookId in JSON format
     */
    @GetMapping(value = "/getById/{BookId}")
    public ResponseEntity<String> getBookDataById(@PathVariable Integer BookId) {
        Book Book = bookService.getBookDataById(BookId);
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully by id (:",Book);
        return new ResponseEntity(dto,HttpStatus.OK);
    }

    /**
     * - Ability to delete book data for particular id
     * @apiNote - accepts the bookId and deletes the data of that book from DB
     * @param BookId - represents book id
     * @return -  bookId and Acknowledgment message
     */
    @DeleteMapping("/delete/{BookId}")
    public ResponseEntity<String> deleteRecordById(@PathVariable Integer BookId){
        ResponseDTO dto = new ResponseDTO("Book Record deleted successfully", bookService.deleteRecordById(BookId));
        return new ResponseEntity(dto,HttpStatus.OK);
    }

    /**
     * 7) @PutMapping :-
     *            @PutMapping Annotation for mapping HTTP PUT requests onto specific handler methods.
     *            Specifically, @PutMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.PUT).
     *
     * Ability to update book data for particular id
     * @apiNote - accepts the book data in JSON format and updates the book having same bookId from database
     * @param BookId - book id
     * @param bookDTO -  represents object of bookDTO class
     * @return - updated book information in JSON format
     */
    @PutMapping("/updateBookById/{BookId}")
    public ResponseEntity<String> updateRecordById(@PathVariable Integer BookId,@Valid @RequestBody BookDTO bookDTO){
        Book updateRecord = bookService.updateRecordById(BookId,bookDTO);
        ResponseDTO dto = new ResponseDTO(" Book Record updated successfully by Id",updateRecord);
        return new ResponseEntity(dto,HttpStatus.ACCEPTED);
    }

    /**
     * create a method name as getBookByName
     * Ability to get book by book name
     * @param name - book name
     * @return - book data
     */
    @GetMapping("searchByBookName/{name}")
    public ResponseEntity<ResponseDTO> getBookByName(@PathVariable("name") String name)
    {
        List<Book> listOfBooks = bookService.getBookByName(name);
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:",listOfBooks);
        return new ResponseEntity(dto,HttpStatus.OK);
    }

    /**
     * ability to get book data in ascending order
     * @return - data in ascending order
     */
    @GetMapping("/sortAsc")
    public ResponseEntity<ResponseDTO> getBooksInAscendingOrder()
    {
        List<Book> listOfBooks = bookService.sortedListOfBooksInAscendingOrder();
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:",listOfBooks);
        return new ResponseEntity(dto,HttpStatus.OK);
    }

    /**
     * ability to get book data in descending order
     * @return - data in descending order
     */
    @GetMapping("/sortDesc")
    public ResponseEntity<ResponseDTO> getBooksInDescendingOrder()
    {
        List<Book> listOfBooks =bookService.sortedListOfBooksInDescendingOrder();
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:",listOfBooks);
        return new ResponseEntity(dto,HttpStatus.OK);
    }

    /**
     * Ability to get book data by author name.
     * @param authorName - put author-name in url
     * @return - book data by author name
     */
    @GetMapping("searchByAuthorName/{authorName}")
    public ResponseEntity<ResponseDTO> getBookByAuthorName(@PathVariable("authorName") String authorName)
    {
        List<Book> listOfBooks = bookService.getBookByAuthorName(authorName);
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully (:",listOfBooks);
        return new ResponseEntity(dto,HttpStatus.OK);
    }

}