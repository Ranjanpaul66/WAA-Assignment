package com.example.assignmentsfiveandsix.services;

import com.example.assignmentsfiveandsix.models.Customer;
import com.example.assignmentsfiveandsix.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    Customer getCustomerById(Long id);
    List<Customer> findAllCustomer();

    List<Customer> findByFirstName(String FirstName);
    List<Customer> findByFirstNameSearch(String FirstName);

    void deleteUser(Long customerId) throws Exception;

}
