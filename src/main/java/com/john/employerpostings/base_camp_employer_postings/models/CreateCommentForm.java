package com.john.employerpostings.base_camp_employer_postings.models;

public class CreateCommentForm{
    public String title;
    public String description;

    public CreateCommentForm(String title, String description){
        this.title = title;
        this.description = description;
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

}
