package com.learning.productsproxy.controller;

import com.learning.productsproxy.entity.Product;
import com.learning.productsproxy.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @Autowired
    IProductService iProductService;

    @GetMapping(value = "/product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId){
        Product product = iProductService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
