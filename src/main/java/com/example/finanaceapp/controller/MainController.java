package com.example.finanaceapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class MainController {
    int a = 0;

    @RequestMapping("/")
    public String home() {
        System.out.println("This is home Page");
        return "welcome";
    }

    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        a = a + 1;
        String message = String.valueOf(a);
        model.put("message", message);
        return "welcome1";
    }


}
