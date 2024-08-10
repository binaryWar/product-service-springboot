package com.scaler.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreResponseDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String image;
    private String description;
}
