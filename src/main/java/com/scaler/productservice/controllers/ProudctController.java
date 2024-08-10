package com.scaler.productservice.controllers;

import com.scaler.productservice.dtos.CreateProductRequestDto;
import com.scaler.productservice.dtos.CreateProductResponseDto;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProudctController {
    private ProductService productService;

    public ProudctController(@Qualifier("dbProductServiceImpl") ProductService productService){
        this.productService = productService;
    }

    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){

        Product product = productService.createProduct(
                createProductRequestDto.toProduct()
        );
        return CreateProductResponseDto.fromProduct(product);
    }
    @GetMapping("")
    public List<CreateProductResponseDto> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return products.stream().map(CreateProductResponseDto::fromProduct).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public CreateProductResponseDto getProductDetails(@PathVariable("id")int id){
        Product product = productService.getProductDetails(id);

        return CreateProductResponseDto.fromProduct(product);
    }
    @PutMapping("/{id}")
    CreateProductResponseDto replaceProodcut(@RequestBody  String x,
                                             @PathVariable("id") Long id
                                             ){
        return null;
    }
}
