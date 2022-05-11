package com.bookstoreapplication.service;

import com.bookstoreapplication.dto.ResponseDTO;
import com.bookstoreapplication.dto.UserDTO;
import com.bookstoreapplication.dto.UserLoginDTO;
import com.bookstoreapplication.model.UserRegistration;

import java.util.List;
/**
 * Created IUserService interface to achieve abstraction
 */
public interface IUserService {

    String addUser(UserDTO userDTO);

    List<UserRegistration> getAllUsers();

    ResponseDTO loginUser(UserLoginDTO userLoginDTO);

    Object getUserByToken(String token);

    String forgotPassword(String email, String password);

    Object getUserByEmailId(String emailId);

    UserRegistration updateUser(String email, UserDTO userDTO);

    String getToken(String email);

    List<UserRegistration> getAllUserDataByToken(String token);

    UserRegistration updateRecordById(Integer id, UserDTO userDTO);

}