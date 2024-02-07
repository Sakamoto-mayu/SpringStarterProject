package com.example.SpringStarterProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SpringStarterProject.form.RequestForm;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {

    @Autowired
    private ServletContext application;

    @GetMapping({ "/", "" })
    public String index() {
        return "exam03";
    }

    @PostMapping({ "/result", "/result/" })
    public String result(RequestForm requestForm) {
        Integer item1 = requestForm.getItem1();
        Integer item2 = requestForm.getItem2();
        Integer item3 = requestForm.getItem3();

        Integer total = (Integer) application.getAttribute("total");
        Integer taxTotal = (Integer) application.getAttribute("taxTotal");

        if (total == null) {
            total = 0;
        }
        if (taxTotal == null) {
            taxTotal = 0;
        }

        application.setAttribute("total", item1 + item2 + item3);
        application.setAttribute("taxTotal", Math.round((item1 + item2 + item3) * 1.1));

        return "exam03-result";
    }

}
