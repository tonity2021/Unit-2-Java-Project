package com.controller;

import jdk.jfr.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")

public class UserController {


//    @GetMapping(path = "/hello")
//    public String helloWorld() {
//        return "Hello World";
//    }
    @GetMapping(path = "/categories/")
    public String getAllCategories() {
        return "all categories";
    }


}