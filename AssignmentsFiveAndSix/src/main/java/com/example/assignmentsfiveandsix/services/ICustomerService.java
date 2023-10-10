package com.example.assignmentsfiveandsix.services;

import com.example.assignmentsfiveandsix.models.Customer;
import com.example.assignmentsfiveandsix.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ICustomerService implements CustomerService {

    private final CustomerRepository customerRepository;

    public ICustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {

        customer.getOrders().stream().forEach(order -> order.setCustomer(customer));
        return customerRepository.save(customer);
    }

    public  Customer updateCustomer(Customer customer){
//        customer.getOrders().stream().forEach(order -> order);
        return null;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findByFirstName(String firstname){
        return customerRepository.findByFirstNameContainsIgnoreCase(firstname);
    }

    @Override
    public List<Customer> findByFirstNameSearch(String firstname){
        return customerRepository.findCustomerByFirstNameContainingIgnoreCase(firstname);
    }

    @Override
    public void deleteUser(Long customerId) throws Exception {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            customerRepository.deleteById(customerId);
        }
    }


}

