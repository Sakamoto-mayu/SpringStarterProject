package com.example.SpringStarterProject.form;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserForm {
    @NotBlank(message = "名前は必須です")
    private String name;
    @Range(min = 1, message = "１歳以上")
    private String age;
    @Size(max = 10, message = "コメントは10文字以内")
    private String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "UserForm [name=" + name + ", age=" + age + ", comment=" + comment + "]";
    }

}
