package com.bookstoreapplication.service;

import com.bookstoreapplication.dto.CartDTO;
import com.bookstoreapplication.dto.ResponseDTO;
import com.bookstoreapplication.model.Cart;

import java.util.Optional;

public interface ICartService {

    ResponseDTO getCartDetails();

    Optional<Cart> getCartDetailsById(Integer cartId);

    Optional<Cart> deleteCartItemById(Integer cartId);

    Cart updateRecordById(Integer cartId, CartDTO cartDTO);

    Cart insertItems(CartDTO cartdto);

    Cart getCartRecordByBookId(Integer bookID);
}