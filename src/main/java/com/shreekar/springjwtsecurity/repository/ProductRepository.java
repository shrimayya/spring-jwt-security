package com.shreekar.springjwtsecurity.repository;

import com.shreekar.springjwtsecurity.entity.Product;
import com.shreekar.springjwtsecurity.entity.User;
import com.shreekar.springjwtsecurity.enums.ProductCategories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
   List<Product> findByName(String name);
    List<Product> findByCategory(ProductCategories productCategories);

}
