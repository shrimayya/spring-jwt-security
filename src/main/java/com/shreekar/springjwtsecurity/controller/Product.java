package com.shreekar.springjwtsecurity.controller;

import com.shreekar.springjwtsecurity.config.MyUserDetailService;
import com.shreekar.springjwtsecurity.enums.ProductCategories;
import com.shreekar.springjwtsecurity.models.AuthRequest;
import com.shreekar.springjwtsecurity.models.AuthResponse;
import com.shreekar.springjwtsecurity.serviceImpl.ProductService;
import com.shreekar.springjwtsecurity.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@RestController
public class Product {

    @Autowired
    public ProductService productService;

    @RequestMapping(path ={"/product","/product/{findby}/{name}","/product/{findby}/{name}","product/{groupBy}"} )
    public ResponseEntity<?>  getProduct(@PathVariable("findby") Optional<String> findBy, @PathVariable("name") Optional<String> name,
                                         @PathVariable("groupBy") Optional<String> groupBy){

        if(groupBy.isPresent()){
            return ResponseEntity.ok(productService.groupBy(groupBy.get()));
        }
        if(findBy.get().equalsIgnoreCase("name")){
            return ResponseEntity.ok(productService.findProductByName(name.get()));
        }
        if(findBy.get().equalsIgnoreCase("category")){
            return ResponseEntity.ok(productService.findProductByCategory(ProductCategories.valueOf(name.get())));
        }



        return  ResponseEntity.ok(Collections.emptyList());

    }


}
