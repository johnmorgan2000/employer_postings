package com.john.employerpostings.base_camp_employer_postings.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreatePostController{

    @GetMapping("/create")
    public String index(){
        return "create_post";
    }
    
}
