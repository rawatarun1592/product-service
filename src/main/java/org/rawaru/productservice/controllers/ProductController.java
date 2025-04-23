package org.rawaru.productservice.controllers;

import org.rawaru.productservice.dtos.CreateProductRequestDto;
import org.rawaru.productservice.dtos.CreateProductResponseDto;
import org.rawaru.productservice.models.Product;
import org.rawaru.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
    public void getAllProducts() {

    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable("id") Long id) {
        return "Here is your product: " +id;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct() {

    }
}
