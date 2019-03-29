package com.john.employerpostings.base_camp_employer_postings.controllers;

import java.util.List;

import com.john.employerpostings.base_camp_employer_postings.models.JobPost;
import com.john.employerpostings.base_camp_employer_postings.models.SortingForm;
import com.john.employerpostings.base_camp_employer_postings.repositories.PostgresJobPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SortingController{
    PostgresJobPostRepository jpRepository;

    @Autowired
    public SortingController(PostgresJobPostRepository repository){
        jpRepository = repository;
    }

    @PostMapping("/jobs")
    public String sortForJobs(Model model, SortingForm form){
        String result = form.getSortBy();
        List<JobPost> jobs = returnSortedJobs(result);
        model.addAttribute("jobs", jobs);
        return "jobs_display";
    }

    @PostMapping("/admin")
    public String sortForAdmin(Model model, SortingForm form){
        String result = form.getSortBy();
        List<JobPost> jobs = returnSortedJobs(result);
        model.addAttribute("jobs", jobs);
        return "admin_jobs";
    }


    public List<JobPost> returnSortedJobs(String result){
        List<JobPost> jobs;
        if(result.equals("newToOld")){
            jobs = jpRepository.findAllByNewest();
        }else if (result.equals("oldToNew")){
            jobs = jpRepository.findAllByOldest();
        }else if (result.equals("a-z")){
            jobs = jpRepository.findAllByATOZ();
        }else if (result.equals("z-a")){
            jobs = jpRepository.findAllByZTOA();
        }
        else{
            jobs = jpRepository.findAllByNewest();
        }
        return jobs;
    }

    
    
}
