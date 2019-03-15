package com.john.employerpostings.base_camp_employer_postings.models;

import javax.validation.constraints.NotNull;

public class SortingForm{
    @NotNull
    public String sortBy;

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    
}


