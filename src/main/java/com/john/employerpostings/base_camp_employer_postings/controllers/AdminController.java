package com.john.employerpostings.base_camp_employer_postings.controllers;

import java.util.List;

import com.john.employerpostings.base_camp_employer_postings.models.Comment;
import com.john.employerpostings.base_camp_employer_postings.models.CreateCommentForm;
import com.john.employerpostings.base_camp_employer_postings.models.JobPost;
import com.john.employerpostings.base_camp_employer_postings.repositories.PostgresJobPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    PostgresJobPostRepository jpRepository;

    @Autowired
    public AdminController(PostgresJobPostRepository repository) {
        jpRepository = repository;
    }

    @GetMapping("/admin")
    public String index() {
        return "admin_home";
    }

    @GetMapping("/admin/jobs")
    public String getJobs(Model model) {
        List<JobPost> jobs = jpRepository.findAllJobs();
        model.addAttribute("jobs", jobs);
        return "admin_jobs";
    }

    @GetMapping("/admin/jobs/{id}")
    public String getDetails(Model model, @PathVariable(value = "id") String id) {
        var detail = jpRepository.findJobById(Integer.parseInt(id));
        
        if (detail.isPresent()) {
            List<Comment> coms =  jpRepository.findPostComments( Integer.parseInt(id));
            model.addAttribute("detail", detail.get());
            model.addAttribute("comments", coms);
            return "admin_job_details";
        } else {
            return "404";
        }
    }

    @PostMapping("/admin/jobs/{id}")
    public String postComment(CreateCommentForm form, Model model, @PathVariable(value = "id") String id) {
        Comment com = new Comment(form.getTitle(), form.getDescription(), Integer.parseInt(id));
        jpRepository.addComment(com);
        return "redirect:/admin/jobs/" + id;
    }
}
