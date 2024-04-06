package com.shoppingapp.service;

import com.shoppingapp.exceptionHandle.ResourceNotFoundException;
import com.shoppingapp.model.Inventory;
import com.shoppingapp.model.Ordered;
import com.shoppingapp.model.Product;
import com.shoppingapp.repo.OrderRepository;
import com.shoppingapp.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;


//    get inventory
    public Inventory getInventory(Long product, Long ordered){

        Product productid = this.productRepository.findById(product).orElseThrow(() ->
                new ResourceNotFoundException("Product", "ProductId", product));

        Ordered orderedid = this.orderRepository.findById(ordered).orElseThrow(() ->
                new ResourceNotFoundException("order","orderId",ordered));

        Inventory inventory=new Inventory();
        inventory.setAvailable(productid.getQuantity());
        inventory.setPrice(productid.getPrice());
        inventory.setOrders(orderedid.getQuantity());

        return inventory;
    }

}
