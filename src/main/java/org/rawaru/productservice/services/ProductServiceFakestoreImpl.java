package org.rawaru.productservice.services;

import org.rawaru.productservice.dtos.FakeStoreCreateProductRequestDto;
import org.rawaru.productservice.dtos.FakeStoreCreateProductResponseDto;
import org.rawaru.productservice.dtos.FakeStoreGetProductResponseDto;
import org.rawaru.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
        FakeStoreGetProductResponseDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                requestDto,
                FakeStoreGetProductResponseDto.class);

//        Product productResponse = new Product();
//        productResponse.setId(response.getId());
//        productResponse.setTitle(response.getTitle());
//        productResponse.setPrice(response.getPrice());
//        productResponse.setDescription(response.getDescription());
//        productResponse.setImageUrl(response.getImage());
//        productResponse.setCategoryName(response.getCategory());
        return response.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreGetProductResponseDto[] response = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreGetProductResponseDto[].class);
//        List<FakeStoreGetProductResponseDto> responseDtoList = Arrays.asList(response);
        List<FakeStoreGetProductResponseDto> responseDtoList = Stream.of(response).toList();
        List<Product> products = new ArrayList<>();
        for(FakeStoreGetProductResponseDto responseDto : responseDtoList){
            products.add(responseDto.toProduct());
        }
        return products;
    }
}
