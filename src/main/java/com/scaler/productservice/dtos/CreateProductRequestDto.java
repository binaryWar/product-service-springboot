package com.scaler.productservice.dtos;

import com.scaler.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    String name;
    double price;
    String description;
    String category;
    public Product toProduct(){
        Product product = new Product();
        product.setDescription(this.description);
        product.setName(this.name);
        product.setPrice(this.price);
        product.setCategory(this.category);
        return product;
    }
}
