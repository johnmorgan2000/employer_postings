package com.john.employerpostings.base_camp_employer_postings.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public List<JobPost> findAllJobs(){
        return jdbc.query("SELECT * FROM employer_posts;", this::mapToJobPost);
    }

    public JobPost mapToJobPost(ResultSet rs, int rowNum) throws SQLException {
        return new JobPost(
        rs.getString("employer_name"), 
        rs.getString("address"), 
        rs.getString("position"), 
        rs.getString("benefits"), 
        rs.getString("apply_url"), 
        rs.getDate("posted_date"));
    }
}