package com.scaler.productservice.services;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repository.CategoryRepository;
import com.scaler.productservice.repository.ProductRepositroy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbProductServiceImpl")
public class ProductServiceDBImpl implements ProductService {
    private ProductRepositroy productRepository;
    private CategoryRepository categoryRepository;
    public ProductServiceDBImpl(ProductRepositroy productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product createProduct(Product product) {
        String categoyName = product.getCategory().getName();
        Optional<Category> category = categoryRepository.findCategoryByName(categoyName);
        Category newCategory;
        if(category.isEmpty()){
            newCategory = categoryRepository.save(product.getCategory());
        }else{
            newCategory = category.get();
        }
        product.setCategory(newCategory);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductDetails(int id) {
        return null;
    }
}
