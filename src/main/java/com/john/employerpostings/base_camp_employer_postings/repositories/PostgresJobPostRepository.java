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
public class PostgresJobPostRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public PostgresJobPostRepository(JdbcTemplate jdbcTemplate) {
        jdbc = jdbcTemplate;
    }

    public Integer countRows() {
        String sql = "SELECT COUNT(*) FROM employer_posts;";
        Integer count = jdbc.queryForObject(sql, Integer.class);
        return count;
    }

    public void addJobPost(JobPost jp){
        String sql = "INSERT INTO employer_posts (company_name, address, position, description, benefits, apply_url, image_url, posted_date, views) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 0);";
        jdbc.update(
            sql, 
            jp.getName(), 
            jp.getAddress(), 
            jp.getPosition(), 
            jp.getDescription(), 
            jp.getBenefits(),
            jp.getApplyUrl(), 
            jp.getImageUrl(), 
            jp.getPostedDate());
        }

    public void addComment(Comment com) {
        String sql = "INSERT INTO admin_comments (title, description, post_id) VALUES (?, ?, ?);";
        jdbc.update(sql, com.getTitle(), com.getDescription(), com.getPostId());
    }

    public List<JobPost> findAllByNewest() {
        return jdbc.query("SELECT * FROM employer_posts ORDER BY posted_date DESC;", this::mapToJobPost);
    }

    public List<JobPost> findAllByOldest() {
        return jdbc.query("SELECT * FROM employer_posts ORDER BY posted_date ASC;", this::mapToJobPost);
    }

    public List<JobPost> findAllByATOZ() {
        return jdbc.query("SELECT * FROM employer_posts ORDER BY company_name ASC;", this::mapToJobPost);
    }

    public List<JobPost> findAllByZTOA() {
        return jdbc.query("SELECT * FROM employer_posts ORDER BY company_name DESC;", this::mapToJobPost);
    }

    public Optional<JobPost> findJobById(int id) {
        String sql = "SELECT * FROM employer_posts WHERE id= ?;";
        return Optional.ofNullable(jdbc.queryForObject(sql, this::mapToJobPost, id));
    }

    public List<Comment> findPostComments(int id) {
        String sql = "SELECT * FROM admin_comments WHERE post_id = ?";
        return jdbc.query(sql, this::mapToComment, id);
    }

    public void deletePost(int id) {
        String sql = "DELETE FROM employer_posts WHERE id = ?;";
        jdbc.update(sql, id);
    }

    public void deleteComment(int id) {
        String sql = "DELETE FROM admin_comments WHERE id = ?;";
        jdbc.update(sql, id);
    }

    public List<JobPost> getTopFive() {
        String sql = "SELECT * FROM employer_posts ORDER BY views DESC LIMIT 5";
        return jdbc.query(sql, this::mapToJobPost);
    }

    public Comment mapToComment(ResultSet rs, int rowNum) throws SQLException {
        return new Comment(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getInt("post_id"));
    }

    public void addViewCount(int id) {
        String sql = "UPDATE employer_posts SET views = views + 1 WHERE id = ?;";
        jdbc.update(sql, id);
    }

    public JobPost mapToJobPost(ResultSet rs, int rowNum) throws SQLException {
        return new JobPost(rs.getInt("id"), rs.getString("company_name"), rs.getString("address"),
                rs.getString("position"), rs.getString("description"), rs.getString("benefits"),
                rs.getString("apply_url"), rs.getString("image_url"), rs.getTimestamp("posted_date"),
                rs.getInt("views"));
    }
}
