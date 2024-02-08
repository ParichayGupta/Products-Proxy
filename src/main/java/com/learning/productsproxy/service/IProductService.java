package com.learning.productsproxy.service;

import com.learning.productsproxy.dto.ProductDTO;
import com.learning.productsproxy.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();

    Product getProductById(final Long productId);

    Product deleteProductById(Long productId);

    ResponseEntity<ProductDTO> addNewProduct(ProductDTO productDto);
}
