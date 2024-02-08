package com.learning.productsproxy.service;

import com.learning.productsproxy.entity.Product;

public interface IProductService {

    public Product getProductById(final Long productId);
}
