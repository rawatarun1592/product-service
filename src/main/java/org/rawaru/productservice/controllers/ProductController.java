package org.rawaru.productservice.controllers;

import org.rawaru.productservice.dtos.*;
import org.rawaru.productservice.models.Product;
import org.rawaru.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {

        Product product = productService.createProduct(createProductRequestDto.toProduct());
        return CreateProductResponseDto.fromProduct(product);
        //return "This product is priced at: " +createProductRequestDto.getPrice();
    }

    @GetMapping("")
    public GetAllProductsResponse getAllProducts() {
        List<Product> products = productService.getAllProducts();
        GetAllProductsResponse response = new GetAllProductsResponse();
        List<GetProductDto> getProductDtos = new ArrayList<>();
        for(Product product : products) {
            getProductDtos.add(GetProductDto.fromProduct(product));
        }
        response.setProducts(getProductDtos);
        return response;

    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable("id") Long id) {
        return "Here is your product: " +id;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct() {

    }
}
