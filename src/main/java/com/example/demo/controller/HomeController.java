package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by addis on 7/17/17.
 */
@RestController
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        return "this is from home";
    }

    @RequestMapping("/private")
    public String privateArea(){
return "this is from private";
    }
}
