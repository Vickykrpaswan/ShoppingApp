package com.shoppingapp.controller;

import com.shoppingapp.model.Customer;
import com.shoppingapp.model.Ordered;
import com.shoppingapp.model.Product;
import com.shoppingapp.service.CustomerService;
import com.shoppingapp.service.OrderService;
import com.shoppingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;


    // post order
    @PostMapping("/customer/{customerId}/product/{productId}/order")
    public ResponseEntity<Ordered> createOrder(@RequestBody Ordered ordered,
                                              @PathVariable Long customerId,
                                              @PathVariable Long productId){
        Ordered order = this.orderService.createOrder(ordered, customerId, productId);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

//  get order
    @GetMapping("/all")
    public ResponseEntity<List<Ordered>> getAllOrders() {

        List<Ordered> ordereds = orderService.getAllOrders();
        return ResponseEntity.ok(ordereds);
    }
}
