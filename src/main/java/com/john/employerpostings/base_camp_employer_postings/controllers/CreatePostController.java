package com.john.employerpostings.base_camp_employer_postings.controllers;

import com.john.employerpostings.base_camp_employer_postings.models.CreatePostForm;
import com.john.employerpostings.base_camp_employer_postings.models.JobPost;
import com.john.employerpostings.base_camp_employer_postings.repositories.PostgresJobPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreatePostController {
    PostgresJobPostRepository jpRepository;

    @Autowired
    public CreatePostController(PostgresJobPostRepository repository){
        jpRepository = repository;
    }

    @GetMapping("/create")
    public String index(){
        return "create_post";
    }

    @PostMapping("/create")
    public String createJob(CreatePostForm form){
        JobPost jp = new JobPost(form.name, form.address, form.position, form.benefits, form.applyUrl);
        jpRepository.addJobPost(jp);
        return "redirect:/";

    }
}
