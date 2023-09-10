package com.htnguyen.demo.repositories;

import com.htnguyen.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositories extends JpaRepository<Product, Long> {
    List<Product> findByProductName(String productName);
}
