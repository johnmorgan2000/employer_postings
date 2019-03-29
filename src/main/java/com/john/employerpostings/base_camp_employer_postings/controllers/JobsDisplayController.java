package com.john.employerpostings.base_camp_employer_postings.controllers;

import java.util.List;

import com.john.employerpostings.base_camp_employer_postings.models.JobPost;
import com.john.employerpostings.base_camp_employer_postings.repositories.PostgresJobPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobsDisplayController {
    PostgresJobPostRepository jpRepository;

    @Autowired
    public JobsDisplayController(PostgresJobPostRepository repository){
        jpRepository = repository;
    }

    @GetMapping("/jobs")
    public String index(Model model){
        List<JobPost> jobs = jpRepository.findAllByNewest();   
        model.addAttribute("jobs", jobs);
        return "jobs_display";
    }
}
