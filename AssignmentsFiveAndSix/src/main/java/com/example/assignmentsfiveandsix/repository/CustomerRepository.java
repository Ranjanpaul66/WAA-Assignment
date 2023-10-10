package com.example.assignmentsfiveandsix.repository;

import com.example.assignmentsfiveandsix.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

List<Customer> findByFirstNameContainsIgnoreCase(String firstName);
List<Customer> findCustomerByFirstNameContainingIgnoreCase(String firstName);
//@Query("SELECT u FROM Customer u WHERE u.firstName=:firstName and u.lastName=:lastName")
@Query("SELECT u FROM Customer u WHERE u.firstName=?1 and u.lastName=?2")
List<Customer> findCustomerByFirstNameAndLastName(String firstName, String lastName);
}


