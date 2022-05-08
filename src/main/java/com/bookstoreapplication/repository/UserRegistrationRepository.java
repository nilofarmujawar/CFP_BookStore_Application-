package com.bookstoreapplication.repository;

import com.bookstoreapplication.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Created UserRegistrationRepository class extending JpaRepository for CRUD operations and for some custom query methods
 */
@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration,Integer> {
    @Query(value = "SELECT * FROM user_registration where email=:email_Id", nativeQuery = true)
    public Optional<UserRegistration> findByEmailid(String email_Id);
}
