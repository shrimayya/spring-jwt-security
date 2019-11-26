package com.shreekar.springjwtsecurity.service;

import com.shreekar.springjwtsecurity.entity.Product;
import com.shreekar.springjwtsecurity.enums.ProductCategories;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {
    public List<Product>findProductByName(String name);
    public List<Product>findProductByCategory(ProductCategories productCategories);

    public Map<Object,List<Product>> groupBy(String brand);
}
