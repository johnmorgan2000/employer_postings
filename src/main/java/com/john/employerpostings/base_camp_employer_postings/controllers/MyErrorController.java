package com.john.employerpostings.base_camp_employer_postings.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyErrorController implements ErrorController{

    @GetMapping("/error")
    public String hangleError(){
        return "404";
    }

    @Override
    public String getErrorPath(){
        return "/404";
    }
}
