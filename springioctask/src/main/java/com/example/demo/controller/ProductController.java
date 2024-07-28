package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/display")
    public String displayProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "displayProducts";
    }
}
