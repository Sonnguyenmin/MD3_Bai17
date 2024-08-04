package com.ra.baitap2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping
    public String home() {
        return "home";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam("firstInput") Double firstInput, @RequestParam("secondInput") Double secondInput, @RequestParam("btnCal") String btnCal, Model model) {
        Double result = (double) 0;
        if(btnCal.equals("add")){
            result = firstInput + secondInput;
            model.addAttribute("calName", "Addition");
            model.addAttribute("result", result);
        }else if(btnCal.equals("sub")){
            result = firstInput - secondInput;
            model.addAttribute("calName", "Subtraction");
            model.addAttribute("result", result);
        }else if(btnCal.equals("mul")){
            result = firstInput * secondInput;
            model.addAttribute("calName", "Multiplication");
            model.addAttribute("result", result);
        }else if(btnCal.equals("divi")) {
            if (secondInput == 0) {
                //show noti
                model.addAttribute("calName", "Error to divide by zero");
                model.addAttribute("result", "nah");
            } else {
                result = firstInput / secondInput;
                model.addAttribute("calName", "Division");
                model.addAttribute("result", result);
            }
        }
        return "home";
    }
}
