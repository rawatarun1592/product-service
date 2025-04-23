package org.rawaru.productservice.services;

import org.rawaru.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService{


    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
