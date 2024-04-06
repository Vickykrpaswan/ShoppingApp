package com.shoppingapp.controller;

import com.shoppingapp.model.Customer;
import com.shoppingapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

//  post customer
    @PostMapping("/createUser")
    public ResponseEntity<Customer> createUser(@RequestBody Customer customer) {
        Customer customer1 = this.customerService.createCustomer(customer);
        return new ResponseEntity<>(customer1,HttpStatus.CREATED);
    }

//    get customer by id
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer user = customerService.getCustomerById(id);
        return ResponseEntity.ok(user);
    }

//    get all customer
    @GetMapping("/users")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> allCustomer = this.customerService.getAllCustomer();
        return new ResponseEntity<>(allCustomer,HttpStatus.OK);
    }

}
