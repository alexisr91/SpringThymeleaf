package com.alexis.ApplicationSpringTh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alexis.ApplicationSpringTh.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
