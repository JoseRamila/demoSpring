package com.desarrollo.demoSpring.controllers;

import com.desarrollo.demoSpring.entities.Product;
import com.desarrollo.demoSpring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Product Rest controller.
 */
@RestController
public class ProductRestController {
    @Autowired
    private ProductService productService;
    @GetMapping ("/productslist")
    public String list(Model model) {
        model.addAttribute("products", productService.listAllProducts());
        System.out.println("Returning products:");
        return "products";}

}