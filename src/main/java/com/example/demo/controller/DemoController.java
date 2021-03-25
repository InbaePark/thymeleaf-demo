package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DemoController {

    @GetMapping("/demo-map")
    public String demoMap(Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Hello World!!");
        map.put("hoge", "HOGE");
        map.put("fuga", "FUGA");
        map.put("piyo", "PIYO");
        model.addAttribute("map", map);
        return "demo-map";
    }

    @GetMapping("/demo-list")
    public String demoList(Model model) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 2, 3));
        list.add(new Integer(4));
        model.addAttribute("list", list);
        return "demo-list";
    }

    @GetMapping("/demo-if")
    public String demoIf(Model model) {
        model.addAttribute("booleanTrue", true);
        model.addAttribute("booleanFalse", false);
        model.addAttribute("numericZero", 0);
        model.addAttribute("numericOne", 1);
        model.addAttribute("charZero", '0');
        model.addAttribute("stringEmpty", "");
        model.addAttribute("stringZero", "0");
        model.addAttribute("stringOff", "off");
        model.addAttribute("stringNo", "no");
        model.addAttribute("stringFalse", "false");
        model.addAttribute("anyObject", new Object());
        model.addAttribute("nullValue", null);

        return "demo-if";
    }
}