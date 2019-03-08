package com.john.employerpostings.base_camp_employer_postings.models;

public class Comment{
    public String title;
    public String description;
    public int postId;

    public Comment(String title, String description, int postId){
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

}
