package com.example.javafilterdemo.service;

import com.example.javafilterdemo.model.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);

    public List<Product> getAllProducts();
}
