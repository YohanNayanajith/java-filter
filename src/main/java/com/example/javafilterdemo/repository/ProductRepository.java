package com.example.javafilterdemo.repository;

import com.example.javafilterdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
