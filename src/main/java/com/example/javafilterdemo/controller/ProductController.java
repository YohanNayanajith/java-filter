package com.example.javafilterdemo.controller;

import com.example.javafilterdemo.model.Product;
import com.example.javafilterdemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @GetMapping("/")
    public ResponseEntity<Product> saveProducts(@RequestBody Product product) {
        return ResponseEntity.ok().body(productService.saveProduct(product));
    }
}
