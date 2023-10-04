package com.example.assignment2.controllers;

import com.example.assignment2.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;


@Controller
public class ProductController {

    @RequestMapping("/products")
    public String getProducts(Model model){

        Product product1 = new Product(1,"Computer", "Hp Laptop V3SD1234", 200.32);

        Product product2 = Product.builder().id(2).title("HP New Brand Laptop").description("Very New Laptop").price(80).build();

        var products = Arrays.asList(product1, product2);
        model.addAttribute("products",products);
        return "products";
    }

    @GetMapping("/getProduct")
    public String getProductById(@RequestParam(value = "productId", required = false) int id, Model model){

        model.addAttribute("product", Product.builder().id(id).title("Ranjan").description("He is good Guy :P ").price(8000).build());

        return "product";
    }

    @GetMapping("/getPathValu/{pathValue}")
    public String getProductBy(@PathVariable("pathValue") String pValue, Model model){

        model.addAttribute("value", pValue);
//        System.out.println("id: "+id);

        return "productsPathValue";
    }

}
