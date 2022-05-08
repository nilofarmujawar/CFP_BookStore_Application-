package com.bookstoreapplication.repository;

import com.bookstoreapplication.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created OrderRepository class extending JpaRepository for CRUD operations and for some custom query methods
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
