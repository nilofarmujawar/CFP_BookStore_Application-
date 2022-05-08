package com.bookstoreapplication.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class

OrderDTO {
    private Integer quantity;
    @NotEmpty(message="Please provide address")
    private String address;
    private Integer userId;
    private Integer bookId;
    private boolean cancel;
    private Integer price;
}