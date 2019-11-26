package com.shreekar.springjwtsecurity.serviceImpl;

import com.shreekar.springjwtsecurity.entity.Product;
import com.shreekar.springjwtsecurity.enums.ProductCategories;
import com.shreekar.springjwtsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService implements com.shreekar.springjwtsecurity.service.ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findProductByName(String name) {
        List<Product> list= new ArrayList<>();
        list= productRepository.findByName(name);

        return list;
    }

    @Override
    public List<Product> findProductByCategory(ProductCategories productCategories) {
        List<Product> list= new ArrayList<>();
        list= productRepository.findByCategory(productCategories);
        return list;
    }

    @Override
    public Map<Object,List<Product>> groupBy(String value) {

        List<Product> list= new ArrayList<>();
        Map<Object,List<Product>> productMap= new HashMap<>();

        list = productRepository.findAll();

        if(value.equalsIgnoreCase("BRAND")){
          productMap =
                    list.stream().collect(Collectors.groupingBy(Product::getBrand));
        }

        if(value.equalsIgnoreCase("COLOR")){
            productMap =
                    list.stream().collect(Collectors.groupingBy(Product::getColor));
        }

        if(value.equalsIgnoreCase("SIZE")){
            productMap =
                    list.stream().collect(Collectors.groupingBy(Product::getSize));

        }


        return productMap;
    }
}
