package com.example.assignment2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UsersController {

    @RequestMapping("/all")
    public String usersList(Model model){

        return "users";
    }


    @RequestMapping("/{:id}")
    public String usersList(){

        return "users";
    }

}
