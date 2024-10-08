package com.alexis.ApplicationSpringTh.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alexis.ApplicationSpringTh.model.Product;
import com.alexis.ApplicationSpringTh.model.ProductType;
import com.alexis.ApplicationSpringTh.repository.ProductRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


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
        model.addAttribute("types", ProductType.values());
        return "newProduct";
    }

    @PostMapping("/product")
    // On recupere l'adresse /product qui est dans l'attribut action du form et on save et soumet le formulaire avec cette méthode 
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult){
        // Binding result collection si il y a des erreurs dans mon controleur
        if(bindingResult.hasErrors()){
            return "newProduct";
        }
        productRepository.save(product);
        return "redirect:/";
        // Me ramene à la page d'accueil
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable Long id,Model model) {
        // Je recupere mon produit vérifié 
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(" Invalid product id: " + id));
        // Expression lambda pour implémenter une exception en 1 ligne. Sucre syntaxique 
        model.addAttribute("product", product);
        model.addAttribute("types", ProductType.values());
        return " editProduct";
    }
    
}
