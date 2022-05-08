package com.bookstoreapplication.controller;

import com.bookstoreapplication.dto.OrderDTO;
import com.bookstoreapplication.dto.ResponseDTO;
import com.bookstoreapplication.model.Order;
import com.bookstoreapplication.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
@RequestMapping("/order")
/**
 * create a class name as OrderController
 */
public class OrderController {
    /**
     * 3) @AutoMapping :-
     *          @Autowiring feature of spring framework enables you to inject the object dependency implicitly.
     *          It internally uses setter or constructor injection.
     *
     * - Autowired IOrderService interface so we can inject its dependency here
     */
    @Autowired
    private IOrderService orderService;

    /**
     * Inserting the data to the order repository
     * @param orderdto - data of the order
     * @return - data of the order
     */
    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertOrder(@Valid @RequestBody OrderDTO orderdto){
        Order newOrder = orderService.insertOrder(orderdto);
        ResponseDTO dto = new ResponseDTO("User registered successfully !",newOrder);
        return new ResponseEntity(dto, HttpStatus.CREATED);
    }

    /**
     * Ability to retrieve all data from the order repository
     * @return -list of orders
     */
    @GetMapping("/retrieveAllOrders")
    public ResponseEntity<ResponseDTO> getAllOrderRecords(){
        List<Order> newOrder = orderService.getAllOrderRecords();
        ResponseDTO dto = new ResponseDTO("All records retrieved successfully !",newOrder);
        return new ResponseEntity(dto,HttpStatus.OK);
    }

    /**
     * Ability to cal api to retrieve order record by id
     * @param id - represent  id
     * @return - order of particular id entered by user
     */
    @GetMapping("/retrieveOrder/{id}")
    public ResponseEntity<ResponseDTO> getBookRecord(@PathVariable Integer id){
        Order newOrder = orderService.getOrderRecord(id);
        ResponseDTO dto = new ResponseDTO("Record retrieved successfully !",newOrder);
        return new ResponseEntity(dto,HttpStatus.OK);
    }

    /**
     * Ability to  update the order in the repository using id entered by user
     * @param id - order id
     * @param orderdto - all data
     * @return - updated data
     */
    @PutMapping("/updateOrder/{id}")
    public ResponseEntity<ResponseDTO> updateBookRecord(@PathVariable Integer id,@Valid @RequestBody OrderDTO orderdto){
        Order newOrder = orderService.updateOrderRecord(id,orderdto);
        ResponseDTO dto = new ResponseDTO("Record updated successfully !",newOrder);
        return new ResponseEntity(dto,HttpStatus.ACCEPTED);
    }

    /**
     *  Ability to delete order of particular id entered by user
     * @param id - order id
     * @return - response dto containing msg and deleted order
     */
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<ResponseDTO> deleteOrderRecord(@PathVariable Integer id){
        Order newOrder = orderService.deleteOrderRecord(id);
        ResponseDTO dto = new ResponseDTO("Record deleted successfully !",newOrder);
        return new ResponseEntity(dto,HttpStatus.ACCEPTED);
    }
}