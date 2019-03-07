package com.john.employerpostings.base_camp_employer_postings.controllers;

import com.john.employerpostings.base_camp_employer_postings.repositories.PostgresJobPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class JobDetailsController{
    PostgresJobPostRepository jpRepository;

    @Autowired
    public JobDetailsController(PostgresJobPostRepository repository){
        jpRepository = repository;
    }

    @GetMapping("/jobs/{id}")
    public String index(Model model, @PathVariable(value = "id") String id){
        var detail = jpRepository.findJobById(Integer.parseInt(id));
        if (detail.isPresent()){
            model.addAttribute("detail", detail.get());
        return "job_detail";
        }else{
            return "404";
        }
        
    }
}
