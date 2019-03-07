package com.john.employerpostings.base_camp_employer_postings.repositories;

import com.john.employerpostings.base_camp_employer_postings.models.JobPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostgresJobPostRepository{
    private JdbcTemplate jdbc;

    @Autowired
    public PostgresJobPostRepository(JdbcTemplate jdbcTemplate){
        jdbc = jdbcTemplate;
    }

    public void addJobPost(JobPost jp){
        jdbc.update(
            "INSERT INTO employer_posts (name, address, position, benefits, apply_url, posted_date) VALUES (?, ?, ?, ?, ?, ?)",
            jp.getName(),
            jp.getAddress(),
            jp.getPosition(),
            jp.getBenefits(),
            jp.getApplyUrl(),
            jp.getPostedDate()
        );
    }
}
