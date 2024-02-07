package com.example.SpringStarterProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SpringStarterProject.form.MemberForm;
import com.example.SpringStarterProject.model.Member;
import com.example.SpringStarterProject.repository.MemberRepository;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
    @Autowired
    private MemberRepository repository;

    @GetMapping({ "/", "" })
    public String index() {
        return "exam05";
    }

    @PostMapping({ "/result", "/result/" })
    public String result(MemberForm memberForm, Model model) {
        List<Member> memberList = repository.find(memberForm.getName());
        model.addAttribute("memberList", memberList);
        return "exam05-result";
    }

}
