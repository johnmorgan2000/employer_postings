package com.john.employerpostings.base_camp_employer_postings.models;

import java.util.Date;

public class JobPost{
    public String name;
    public String address;
    public String position;
    public String benefits;
    public String applyUrl;
    public Date postedDate;

    public JobPost(String name, String address, String position, String benefits, String applyUrl){
        this.name = name;
        this.address = address;
        this.position = position;
        this.benefits = benefits;
        this.applyUrl = applyUrl;
        this.postedDate = getTime();
    }

    public JobPost(String name, String address, String position, String benefits,String applyUrl, Date postedDate){
        this.name = name;
        this.address = address;
        this.position = position;
        this.benefits = benefits;
        this.applyUrl = applyUrl;
        this.postedDate = postedDate;
    }

    public static Date getTime(){
        Date date = new Date();
        return new Date(date.getTime());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getApplyUrl() {
        return applyUrl;
    }

    public void setApplyUrl(String applyUrl) {
        this.applyUrl = applyUrl;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    
}
