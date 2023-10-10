package com.example.assignmentsfiveandsix.controllers;


import com.example.assignmentsfiveandsix.models.Customer;
import com.example.assignmentsfiveandsix.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;
    @PostMapping
    public Customer saveCustomer(@RequestBody Customer c){

        return customerService.saveCustomer(c);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer c){

        return customerService.saveCustomer(c);
    }

    @GetMapping
    public List<Customer> allCustomers(@RequestParam(required = false) String firstName){
        if(firstName!=null && firstName !=""){
            return customerService.findByFirstName(firstName);
        }
        return customerService.findAllCustomer();
    }

    @GetMapping("/search")
    public List<Customer> allCustomersSearch(@RequestParam(required = false) String firstName){
        if(firstName!=null && firstName !=""){
            return customerService.findByFirstName(firstName);
        }
        return customerService.findByFirstNameSearch(firstName);
    }


    @DeleteMapping("/{customerId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long customerId) throws Exception {
        customerService.deleteUser(customerId);
    }



}
