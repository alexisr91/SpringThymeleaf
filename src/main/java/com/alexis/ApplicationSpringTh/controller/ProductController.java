package com.alexis.ApplicationSpringTh.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.alexis.ApplicationSpringTh.model.Product;
import com.alexis.ApplicationSpringTh.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductRepository productRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "index";
        // Index correspondra au fichier html sur lequel le repo sera retourné
    }

    @GetMapping("/product/new")
    public String newProduct(Model model){
        // On retourne un nouveau produit dans le model
        model.addAttribute("product", new Product());
        return "newProduct";
    }
}
