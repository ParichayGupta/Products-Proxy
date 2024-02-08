package com.learning.productsproxy.controller;

import com.learning.productsproxy.dto.ProductDTO;
import com.learning.productsproxy.entity.Product;
import com.learning.productsproxy.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    IProductService iProductService;

    @GetMapping(value = "/product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId){
        Product product = iProductService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = iProductService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ProductDTO> addNewProduct(@RequestBody ProductDTO productDto){
        return iProductService.addNewProduct(productDto);
    }

    @DeleteMapping(value = "/delete/{productId}")
    public ResponseEntity<Product> deleteProductById(@PathVariable Long productId){
        Product product = iProductService.deleteProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
