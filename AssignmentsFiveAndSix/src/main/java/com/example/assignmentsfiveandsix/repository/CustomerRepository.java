package com.example.assignmentsfiveandsix.repository;

import com.example.assignmentsfiveandsix.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

List<Customer> findByFirstNameContainsIgnoreCase(String firstName);
List<Customer> findCustomerByFirstNameContainingIgnoreCase(String firstName);

}


