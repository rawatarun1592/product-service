package org.rawaru.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllProductsResponse {

    private List<GetProductDto> products;
}
