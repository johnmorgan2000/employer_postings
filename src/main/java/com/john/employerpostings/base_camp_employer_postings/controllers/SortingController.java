package com.john.employerpostings.base_camp_employer_postings.controllers;

import java.util.List;

import com.john.employerpostings.base_camp_employer_postings.models.JobPost;
import com.john.employerpostings.base_camp_employer_postings.models.SortingForm;
import com.john.employerpostings.base_camp_employer_postings.repositories.PostgresJobPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SortingController{
    PostgresJobPostRepository jpRepository;

    @Autowired
    public SortingController(PostgresJobPostRepository repository){
        jpRepository = repository;
    }

    @PostMapping("/jobs")
    public String index(Model model, SortingForm form){
        List<JobPost> jobs;
        String result = form.getSortBy();
        if(result.equals("newToOld")){
            jobs = jpRepository.findAllByNewest();
        }else if (result.equals("oldToNew")){
            jobs = jpRepository.findAllByOldest();
        }
        else{
            jobs = jpRepository.findAllByNewest();
        }
        model.addAttribute("jobs", jobs);
        return "jobs_display";
    }
}
