package com.example.SpringStarterProject.form;

public class RequestForm {
    private String name;
    private String num1;
    private String num2;
    private String item1;
    private String item2;
    private String item3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum1() {
        return Integer.parseInt(num1);
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return Integer.parseInt(num2);
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public Integer getItem1() {
        return Integer.parseInt(item1);
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public Integer getItem2() {
        return Integer.parseInt(item2);
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public Integer getItem3() {
        return Integer.parseInt(item3);
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return "RequestForm [name=" + name + ", num1=" + num1 + ", num2=" + num2 + ", item1=" + item1 + ", item2="
                + item2 + ", item3=" + item3 + "]";
    }
}
