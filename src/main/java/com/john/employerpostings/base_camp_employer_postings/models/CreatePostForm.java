package com.john.employerpostings.base_camp_employer_postings.models;

import java.sql.Date;

import javax.validation.constraints.NotNull;

public class CreatePostForm{
    @NotNull
    public String name;
    @NotNull
    public String address;
    @NotNull
    public String position;
    @NotNull
    public String benefits;

    public String applyUrl;

}
