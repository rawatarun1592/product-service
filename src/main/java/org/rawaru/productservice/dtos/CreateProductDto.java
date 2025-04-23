package org.rawaru.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.rawaru.productservice.models.Product;

@Getter
@Setter
public class CreateProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    public static CreateProductDto fromProduct(Product product) {
        CreateProductDto dto = new CreateProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setImageUrl(product.getImageUrl());
        return dto;
    }
}
