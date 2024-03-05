package com.itvedant.petstoreapp.entities;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Product {
    private Integer id;

    @NotNull
    @Length(min = 3, max = 20, message = "product name should have 3 - 20 characters")
    private String name;
    @NotNull
    @Min(value = 0)
    @Max(value = 4000)
    private Double price;
    private String description;
}
