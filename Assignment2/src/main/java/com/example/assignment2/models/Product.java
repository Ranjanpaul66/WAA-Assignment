package com.example.assignment2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Product {

    private int id;
    private String title;
    private String description;
    private double price;
}
