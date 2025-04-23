package org.rawaru.productservice.services;

import org.rawaru.productservice.dtos.FakeStoreCreateProductRequestDto;
import org.rawaru.productservice.dtos.FakeStoreCreateProductResponseDto;
import org.rawaru.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
//@Primary
public class ProductServiceFakestoreImpl implements ProductService{

    private RestTemplate restTemplate;
    public ProductServiceFakestoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {

        FakeStoreCreateProductRequestDto requestDto = new FakeStoreCreateProductRequestDto();
        requestDto.setCategory(product.getCategoryName());
        requestDto.setDescription(product.getDescription());
        requestDto.setPrice(product.getPrice());
        requestDto.setTitle(product.getTitle());
        requestDto.setImage(product.getImageUrl());
        FakeStoreCreateProductResponseDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                requestDto,
                FakeStoreCreateProductResponseDto.class);

        Product productResponse = new Product();
        productResponse.setId(response.getId());
        productResponse.setTitle(response.getTitle());
        productResponse.setPrice(response.getPrice());
        productResponse.setDescription(response.getDescription());
        productResponse.setImageUrl(response.getImage());
        productResponse.setCategoryName(response.getCategory());
        return productResponse;
    }
}
