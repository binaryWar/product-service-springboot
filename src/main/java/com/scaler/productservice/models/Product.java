package com.scaler.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product  extends  BaseModel{
    private String name;
    private double price;
    private String description;
    @ManyToOne
    private Category category;
}
