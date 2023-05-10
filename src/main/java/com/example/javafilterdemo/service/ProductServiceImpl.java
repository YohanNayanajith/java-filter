package com.example.javafilterdemo.service;

import com.example.javafilterdemo.model.Product;
import com.example.javafilterdemo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl {
    private final ProductRepository productRepository;
    private Product saveProduct(Product product){
        return productRepository.save(product);
    }

    private List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
