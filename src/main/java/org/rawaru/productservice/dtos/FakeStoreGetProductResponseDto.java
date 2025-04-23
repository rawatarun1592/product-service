package org.rawaru.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.rawaru.productservice.models.Product;

@Getter
@Setter
public class FakeStoreGetProductResponseDto {
    private Long id;
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;

    public Product toProduct(){
        Product product = new Product();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.image);
        product.setCategoryName(this.category);
        return product;
    }
}
