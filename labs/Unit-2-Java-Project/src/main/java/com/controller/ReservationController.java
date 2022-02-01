package com.controller;

import jdk.jfr.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")

public class ReservationController {


    //    @GetMapping(path = "/hello")
//    public String helloWorld() {
//        return "Hello World";
//    }
    @GetMapping(path = "/reservations/") //get all 'reservations' endpoint is working
    public String getAllCategories() {
        return "all categories";
    }


}