package com.electronicticket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
    @GetMapping("test")
    public String name(){
        return "孟姣姣";
    }
}
