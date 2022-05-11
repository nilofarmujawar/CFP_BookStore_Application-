package com.bookstoreapplication.service;

import com.bookstoreapplication.dto.CartDTO;
import com.bookstoreapplication.dto.ResponseDTO;
import com.bookstoreapplication.model.Cart;

import java.util.Optional;
/**
 * Created ICartService interface to achieve abstraction
 */

public interface ICartService {

    ResponseDTO getCartDetails();

    Cart getCartDetailsById(Integer cartId);

    Cart deleteCartItemById(Integer cartId);

    Cart updateRecordById(Integer cartId, CartDTO cartDTO);

    Cart insertItems(CartDTO cartdto);

    Cart getCartRecordByBookId(Integer bookID);
}