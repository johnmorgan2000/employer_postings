package com.john.employerpostings.base_camp_employer_postings.controllers;

import com.john.employerpostings.base_camp_employer_postings.repositories.PostgresJobPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {
    PostgresJobPostRepository jpRepository;

    @Autowired
    public LandingController(PostgresJobPostRepository repository){
        jpRepository = repository;
    }
    
    @GetMapping("/")
    public String getLanding(Model model){
        Integer count = jpRepository.countRows();
        model.addAttribute("count", count);
        return "landing";
    }
    
}
