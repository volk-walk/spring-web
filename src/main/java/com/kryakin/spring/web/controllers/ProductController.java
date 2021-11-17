package com.kryakin.spring.web.controllers;

import com.kryakin.spring.web.data.Product;
import com.kryakin.spring.web.repositories.ProductRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }



    @GetMapping("/products/{id}")
    private String showProductInfo(@PathVariable Long id, Model model){
        Product product = productRepository.getProductById(id);
        model.addAttribute("product", product);
        return "product_info";
    }

    @GetMapping("/products")
    private String showProductsPage(Model model){
        model.addAttribute("products",productRepository.getProductList());
        return "products_page";
    }
}
