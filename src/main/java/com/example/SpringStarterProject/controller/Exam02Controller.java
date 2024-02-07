package com.example.SpringStarterProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SpringStarterProject.form.RequestForm;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {

    @Autowired
    private HttpSession session;

    @GetMapping({ "/", "" })
    public String index() {
        return "exam02";
    }

    @PostMapping({ "/result", "/result/" })
    public String result(RequestForm requestForm) {
        session.setAttribute("num1", requestForm.getNum1());
        session.setAttribute("num2", requestForm.getNum2());
        session.setAttribute("result", requestForm.getNum1() +
                requestForm.getNum2());
        return "exam02-result";
    }

    @GetMapping({ "/result2", "/result2/" })
    public String result2(RequestForm requestForm) {
        return "exam02-result2";
    }

}
