package org.rawaru.productservice.services;

import org.rawaru.productservice.models.Product;

import java.util.List;


public interface ProductService {

    Product createProduct(Product product);
    List<Product> getAllProducts();

}
