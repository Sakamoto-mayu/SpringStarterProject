package com.example.SpringStarterProject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SpringStarterProject.form.CartForm;
import com.example.SpringStarterProject.model.Item;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/exam06")
public class ShoppingCartController {
    @Autowired
    private ServletContext application;
    @Autowired
    private HttpSession session;

    @GetMapping("/")
    public String index() {

        /**
         * (applicationスコープ)商品リスト
         */
        List<Item> itemList = new LinkedList<>();
        Item item1 = new Item();
        item1.setName("手帳ノート");
        item1.setPrice("1000");
        itemList.add(item1);

        Item item2 = new Item();
        item2.setName("文房具セット");
        item2.setPrice("1500");
        itemList.add(item2);

        Item item3 = new Item();
        item3.setName("ファイル");
        item3.setPrice("2000");
        itemList.add(item3);

        application.setAttribute("itemList", itemList);
        System.out.println(application.getAttribute("itemList"));

        /**
         * (sessionスコープ)ショッピングカート
         */
        if (session.getAttribute("cartList") == null) {
            List<Item> cartList = new LinkedList<>();
            session.setAttribute("cartList", cartList);
        }

        /**
         * (リクエストスコープ)合計金額
         */

        return "item-and-cart";
    }

    @PostMapping({ "/addItem", "/addItem/" })
    public String addItem(CartForm cartForm) {
        String indexStr = cartForm.getIndex();
        int index = Integer.parseInt(indexStr);
        System.out.println(index);

        List<Item> itemList = (List<Item>) application.getAttribute("itemList");
        Item selectedItem = itemList.get(index);
        System.out.println(selectedItem);

        List<Item> cartList = (List<Item>) session.getAttribute("cartList");
        cartList.add(selectedItem);
        session.setAttribute("cartList", cartList);

        return "redirect:/exam06/";
    }

    @PostMapping({ "/delete", "/delete" })
    public String delete(CartForm cartForm) {
        int indexStr = cartForm.getDeleteIndex();

        List<Item> cartList = (List<Item>) session.getAttribute("cartList");
        cartList.remove(indexStr);

        return "redirect:/exam06/";
    }
}
