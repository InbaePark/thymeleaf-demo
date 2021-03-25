package com.example.demo.controller;

import com.example.demo.form.MyForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class FormController {

    @GetMapping
    public String init(Model model) {
        model.addAttribute(new MyForm());
        return "form";
    }

    @PostMapping
    public String submit(@Validated @ModelAttribute MyForm form, BindingResult result) {
        System.out.println("form.value=" + form.getValue());
        System.out.println("form.checked=" + form.isChecked());
        System.out.println("form.selectedRadio=" + form.getSelectedRadio());
        System.out.println("form.selectedOption=" + form.getSelectedOption());
        System.out.println("result = " + result);
        return "form";
    }
}