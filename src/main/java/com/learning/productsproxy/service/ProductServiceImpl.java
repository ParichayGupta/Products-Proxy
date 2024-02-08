package com.learning.productsproxy.service;

import com.learning.productsproxy.dto.ProductDTO;
import com.learning.productsproxy.entity.Category;
import com.learning.productsproxy.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public Product getProductById(final Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductDTO productDTO = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDTO.class, productId).getBody();
        assert productDTO != null;
        return mapProductDTOToProduct(productDTO);
    }

    @Override
    public Product deleteProductById(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductDTO productDTO = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDTO.class, productId).getBody();
        return mapProductDTOToProduct(productDTO);
    }

    @Override
    public ResponseEntity<ProductDTO> addNewProduct(ProductDTO productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.postForEntity("https://fakestoreapi.com/products", productDto, ProductDTO.class);
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ProductDTO[] productDTOS = restTemplate.getForEntity("https://fakestoreapi.com/products",ProductDTO[].class).getBody();
        List<Product> products = new ArrayList<>();
        for(ProductDTO dto : productDTOS){
            products.add(mapProductDTOToProduct(dto));
        }
        return products;
    }

    private Product mapProductDTOToProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        Category category = new Category();
        category.setName(productDTO.getCategory());
        product.setCategory(category);
        product.setImageURL(productDTO.getImage());
        return product;
    }
}
