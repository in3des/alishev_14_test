package com.in3des.springlesson.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage() {
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calc")
    public String calculator(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b, @RequestParam(value = "operator") String s, ModelMap model) {

        double result;

        switch (s) {
            case "sum":
                result = a + b;
                break;
            case "minus":
                result = a - b;
                break;
            case "mult":
                result = a * b;
                break;
            case "div":
                result = a / (double) b;
                break;
            default:
                result = 0;
                break;
        }

        model.addAttribute("result", result);

        return "first/calc";
    }
}
