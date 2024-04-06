package com.shoppingapp.service;

import com.shoppingapp.exceptionHandle.ResourceNotFoundException;
import com.shoppingapp.model.Ordered;
import com.shoppingapp.model.Product;
import com.shoppingapp.model.Customer;
import com.shoppingapp.repo.CustomerRepository;
import com.shoppingapp.repo.OrderRepository;
import com.shoppingapp.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;


//    get Al  orders

    public List<Ordered> getAllOrders() {
        return orderRepository.findAll();
    }

//    create orders
    public Ordered createOrder(Ordered ordered, Long customerId, Long productId) {

//        fetch customer if customerId are available
        Customer customer = this.customerRepository.findById(customerId).orElseThrow(() ->
                new ResourceNotFoundException("Customer", "CustomerId", customerId));

//        fet product if productId are available
        Product product = this.productRepository.findById(productId).orElseThrow(() ->
                new ResourceNotFoundException("Product","ProductId",productId));

//        check order quantity < less then product quantity
        if (product.getQuantity() < ordered.getQuantity()){
            throw new IllegalArgumentException("Product not available in desired quantity");
        }
        ordered.setCustomer(customer);
        ordered.setProduct(product);
        ordered.setQuantity(ordered.getQuantity());
        ordered.setPaymentStatus(ordered.isPaymentStatus());

//        set product quantity according to ordered quantity
        product.setQuantity(product.getQuantity()-ordered.getQuantity());

        return this.orderRepository.save(ordered);
    }

}
