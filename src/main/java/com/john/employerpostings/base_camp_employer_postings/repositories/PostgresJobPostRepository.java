package com.john.employerpostings.base_camp_employer_postings.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.john.employerpostings.base_camp_employer_postings.models.Comment;
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

    public void addComment(Comment com){
        String sql = "INSERT INTO admin_comments (title, description, post_id) VALUES (?, ?, ?);";
        jdbc.update(sql, com.getTitle(), com.getDescription(), com.getPostId());
    }

    public List<JobPost> findAllJobs(){
        return jdbc.query("SELECT * FROM employer_posts;", this::mapToJobPost);
    }

    public Optional<JobPost> findJobById(int id){
        String sql = "SELECT * FROM employer_posts WHERE id= ?;";
        return Optional.ofNullable(jdbc.queryForObject(sql, this::mapToJobPost, id));
    }

    public List<Comment> findPostComments(int id){
        String sql = "SELECT * FROM admin_comments WHERE id = ?";
        return jdbc.query(sql, this::mapToComment, id);
    }

    public Comment mapToComment(ResultSet rs, int rowNum) throws SQLException {
        return new Comment(
            rs.getString("title"),
            rs.getString("description"),
            rs.getInt("post_id")
        );
    }

    public JobPost mapToJobPost(ResultSet rs, int rowNum) throws SQLException {
        return new JobPost(
        rs.getInt("id"),
        rs.getString("employer_name"), 
        rs.getString("address"), 
        rs.getString("position"), 
        rs.getString("benefits"), 
        rs.getString("apply_url"), 
        rs.getDate("posted_date"));
    }
}
