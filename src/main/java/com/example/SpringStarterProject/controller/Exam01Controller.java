package com.example.SpringStarterProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SpringStarterProject.form.RequestForm;

@Controller
@RequestMapping("/exam01")
public class Exam01Controller {

    @GetMapping({ "/", "" })
    public String index() {
        return "exam01";
    }

    @PostMapping({ "/display", "/display/" })
    public String display(RequestForm requestForm, Model model) {
        model.addAttribute("name", requestForm.getName());
        return "exam01-result";
    }
}
