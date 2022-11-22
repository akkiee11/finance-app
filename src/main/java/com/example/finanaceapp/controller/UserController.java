package com.example.finanaceapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap modelMap) {
        modelMap.addAttribute("userName", "Temp User");
        modelMap.addAttribute("emailId", "Temp Email ID");
        return "user";
    }
}
