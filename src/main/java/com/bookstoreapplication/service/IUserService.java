package com.bookstoreapplication.service;

import com.bookstoreapplication.dto.ResponseDTO;
import com.bookstoreapplication.dto.UserDTO;
import com.bookstoreapplication.model.UserRegistration;

import java.util.List;

public interface IUserService {

    String addUser(UserDTO userDTO);

    List<UserRegistration> getAllUsers();

  ResponseDTO loginUser(String email_id, String password);

    Object getUserById(String token);

    String forgotPassword(String email, String password);

    Object getUserByEmailId(String emailId);

    UserRegistration updateUser(String email, UserDTO userDTO);

    String getToken(String email);

    List<UserRegistration> getAllUserDataByToken(String token);

    UserRegistration updateRecordByToken(Integer id, UserDTO userDTO);
   ;
}