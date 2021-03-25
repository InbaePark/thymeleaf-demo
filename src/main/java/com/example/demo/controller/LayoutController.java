package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LayoutController {

    @GetMapping("/layout")
    public String method() {
        return "layout/content";
    }

    @GetMapping("/modal")
    public String modal() {
        return "demo-modal";
    }

    @GetMapping("/booklist")
    public String booklist() {
        return "booklist";
    }
}