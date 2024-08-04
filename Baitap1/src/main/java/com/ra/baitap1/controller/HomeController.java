package com.ra.baitap1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @RequestMapping(value ={ "/", "/home"})
    public String home() {
        return "home";
    }

    @PostMapping("/add")
    public String add(@RequestParam("vegetables") List<String> vegetables, Model model) {
        model.addAttribute("selectedVegetables", String.join(", ", vegetables));
        return "home";
    }
}
