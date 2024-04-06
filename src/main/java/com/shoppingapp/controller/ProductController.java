package com.shoppingapp.controller;

import com.shoppingapp.model.Product;
import com.shoppingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

//    post product
    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product product1 = this.productService.createProduct(product);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

//    get product
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

//    get product by id
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

}
