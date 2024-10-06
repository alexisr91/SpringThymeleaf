package com.alexis.ApplicationSpringTh.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.Year;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull(message =" Product type cannot be null")
    private ProductType productType;

    @NotBlank(message =" Brand type cannot be null")
    private String brand;

    @NotBlank(message =" Model type cannot be null")
    private String model;

    @NotNull(message =" Price type cannot be null")
    @Positive
    // @Positive = uniquement des valeurs positives
    private Double price;

    @NotNull(message =" Year type cannot be null")
    private Year year;
}
