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

    public Integer countRows(){
        String sql = "SELECT COUNT(*) FROM employer_posts;";
        Integer count = jdbc.queryForObject(sql, Integer.class);
        return count;
    }

    public void addJobPost(JobPost jp){
        String sql = "INSERT INTO employer_posts (employer_name, address, position, benefits, apply_url, posted_date) VALUES (?, ?, ?, ?, ?, ?);";
        jdbc.update(
            sql,
            jp.getName(),
            jp.getAddress(),
            jp.getPosition(),
            jp.getBenefits(),
            jp.getApplyUrl(),
            jp.getPostedDate()
        );
    }
}
