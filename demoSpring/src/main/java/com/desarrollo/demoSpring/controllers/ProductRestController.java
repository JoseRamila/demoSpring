package com.desarrollo.demoSpring.controllers;

import com.desarrollo.demoSpring.entities.Product;
import com.desarrollo.demoSpring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * Product Rest controller.
 */
@RestController
public class ProductRestController {
    @Autowired
    private ProductService productService;
    @GetMapping ("/productslist")
    public List<Product> productList(){
        System.out.println("Returning products:");
        return (List<Product>) productService.listAllProducts();
    }
    @PostMapping("/newproduct")
    public ResponseEntity<String> saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return  new ResponseEntity<>("Product created", HttpStatus.OK);
    }




}