package com.htnguyen.demo.controllers;


import com.htnguyen.demo.models.Product;
import com.htnguyen.demo.models.ResponseObject;
import com.htnguyen.demo.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/Products")
public class ProductControllers {

    @Autowired
    private ProductRepositories productRepositories;

    @GetMapping("")
    List<Product> getAllProduct() {
        return productRepositories.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Product> foundProduct = productRepositories.findById(id);
        return foundProduct.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(
                        "Success",
                        "Query product success",
                        foundProduct
                )
        ) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject(
                        "Success",
                        "Cannot found this product",
                        ""
                )
        );
    }
}
