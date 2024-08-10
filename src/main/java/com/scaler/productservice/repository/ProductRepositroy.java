package com.scaler.productservice.repository;

import com.scaler.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositroy extends JpaRepository<Product,Long> {
    @Override
    Product save(Product product);
}
