package org.rawaru.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.rawaru.productservice.models.Product;

@Getter
@Setter
public class GetProductDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    public static GetProductDto fromProduct(Product product) {
        GetProductDto dto = new GetProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setImageUrl(product.getImageUrl());
        return dto;
    }
}
