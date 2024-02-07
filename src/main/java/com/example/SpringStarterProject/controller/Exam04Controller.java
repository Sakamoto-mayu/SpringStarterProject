package com.example.SpringStarterProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.SpringStarterProject.form.UserForm;
import com.example.SpringStarterProject.model.User;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
    @GetMapping({ "/", "" })
    public String index(Model model, UserForm userForm) {
        model.addAttribute("name", userForm.getName());
        model.addAttribute("age", userForm.getAge());
        model.addAttribute("comment", userForm.getComment());
        return "exam04";
    }

    @PostMapping({ "/result", "/result/" })
    public String result(@Validated UserForm userForm, BindingResult result, Model model,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return index(model, userForm);
        }

        User user = new User();
        user.setName(userForm.getName());
        user.setAge(userForm.getAge());
        user.setComment(userForm.getComment());

        redirectAttributes.addAttribute("name", user.getName());
        redirectAttributes.addAttribute("age", user.getAge());
        redirectAttributes.addAttribute("comment", user.getComment());

        return "exam04-result";
    }

}
