package com.shoppingapp.service;

import com.shoppingapp.model.Customer;
import com.shoppingapp.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

//    create customer
    public Customer createCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

//    get customer by id
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

//    get all customer
    public List<Customer> getAllCustomer(){
        return this.customerRepository.findAll();
    }
}
