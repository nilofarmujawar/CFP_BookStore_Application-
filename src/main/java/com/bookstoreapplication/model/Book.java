package com.bookstoreapplication.model;

import com.bookstoreapplication.dto.BookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Book {
    /**
     * variables
     */
    @Id
    @GeneratedValue
    private Integer bookId;
    private String  bookName;
    private String  authorName;
    private String  bookDescription;
    private String  bookImage;
    private Integer price;
    private Integer quantity;

    /**
     *  parameterized constructor
     * @param bookDTO - all book data
     */
    public Book(BookDTO bookDTO){
        this.authorName=bookDTO.getAuthorName();
        this.bookDescription=bookDTO.getBookDescription();
        this.bookImage=bookDTO.getBookImage();
        this.price=bookDTO.getPrice();
        this.quantity=bookDTO.getQuantity();
        this.bookName=bookDTO.getBookName();
    }

    /**
     * parameterized constructor
     * @param bookId - book id
     * @param bookDTO - all book data
     */
    public Book(Integer bookId, BookDTO bookDTO){
        this.bookId=bookId;
        this.bookName=bookDTO.getBookName();
        this.authorName=bookDTO.getAuthorName();
        this.bookImage=bookDTO.getBookImage();
        this.quantity=bookDTO.getQuantity();
        this.price=bookDTO.getPrice();
        this.bookDescription=bookDTO.getBookDescription();

    }
}