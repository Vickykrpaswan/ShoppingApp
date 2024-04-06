package com.shoppingapp.service;

import com.shoppingapp.model.Product;
import com.shoppingapp.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

//    create product
    public Product createProduct(Product product){
        return this.productRepository.save(product);
    }

//    get all product
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

//    get product by id
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
    }
}
