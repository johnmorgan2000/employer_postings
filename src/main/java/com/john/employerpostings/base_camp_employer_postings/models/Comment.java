package com.john.employerpostings.base_camp_employer_postings.models;

public class Comment{
	public Integer comment_id;
    public String title;
    public String description;
    public int postId;

    public Comment(String title, String description, int postId){
        this.title = title;
        this.description = description;
        this.postId = postId;
	}
	
	public Comment(Integer comment_id, String title, String description, int postId ){
		this.comment_id = comment_id;
		this.title = title;
        this.description = description;
        this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public Integer getComment_id() {
		return comment_id;
	}

	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}

	

}
