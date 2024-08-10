package com.scaler.productservice.dtos;

import com.scaler.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;

    public static CreateProductResponseDto fromProduct(Product product) {
        CreateProductResponseDto responseDto = new CreateProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setTitle(product.getName());
        responseDto.setPrice(product.getPrice());
        responseDto.setCategory(product.getCategory().getName());
        return responseDto;
    }
}
