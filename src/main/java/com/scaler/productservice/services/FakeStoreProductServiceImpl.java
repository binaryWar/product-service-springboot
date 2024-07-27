package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreRequestDto;
import com.scaler.productservice.dtos.FakeStoreResponseDto;
import com.scaler.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreRequestDto request = new FakeStoreRequestDto();

        request.setTitle(product.getName());
        request.setCategory(product.getCategory());
        request.setDescription(product.getDescription());
        request.setPrice(product.getPrice());

        FakeStoreResponseDto response = this.restTemplate.postForObject(
            "https://fakestoreapi.com/products",
                request,
                FakeStoreResponseDto.class
        );
        Product product1 = new Product();

        product1.setCategory(response.getCategory());
        product1.setPrice(response.getPrice());
        product1.setId(response.getId());
        product1.setDescription(response.getDescription());
        product1.setName(response.getTitle());

        return product1;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreResponseDto[] response = this.restTemplate.getForObject(
        "https://fakestoreapi.com/products",
        FakeStoreResponseDto[].class
        );
        return Arrays.stream(response).map(fakeProduct->{
            Product product = new Product();
            product.setCategory(fakeProduct.getCategory());
            product.setPrice(fakeProduct.getPrice());
            product.setId(fakeProduct.getId());
            product.setDescription(fakeProduct.getDescription());
            product.setName(fakeProduct.getTitle());
            return  product;
        }).toList();
    }

}
