package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello Thymeleaf!!");
        return "hello";
    }

    @GetMapping("/hello1")
    public String hello1(Model model) {
        model.addAttribute("modelValue", "Model Value!!");
        return "hello";
    }

    @GetMapping("/hello2")
    public String hello2(Model model) {
        model.addAttribute("hoge", new Hoge());
        return "hello";
    }

    public static class Hoge {
        public int publicField = 1;

        public int publicMethod() {return 2;}

        public int getPublicValue() {return 3;}
    }
}