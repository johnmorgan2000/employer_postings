package com.john.employerpostings.base_camp_employer_postings.models;

import java.sql.Timestamp;
import java.util.Date;

public class JobPost{
    public int id;
    public String name;
    public String address;
    public String position;
    public String description;
    public String benefits;
    public String applyUrl;
    public String imageUrl;
    public Timestamp postedDate;

    public JobPost(String name, String address, String position, String description, String benefits, String applyUrl, String imageUrl){
        this.name = name;
        this.address = address;
        this.position = position;
        this.description = description;
        this.benefits = benefits;
        this.applyUrl = applyUrl;
        this.imageUrl = imageUrl;
        this.postedDate = getTime();
    }

    public JobPost(int id, String name, String address, String position, String description, String benefits,String applyUrl, String imageUrl, Timestamp postedDate){
        this.id = id;
        this.name = name;
        this.address = address;
        this.position = position;
        this.description = description;
        this.benefits = benefits;
        this.applyUrl = applyUrl;
        this.imageUrl = imageUrl;
        this.postedDate = postedDate;
    }

    public static Timestamp getTime(){
        Date date = new Date();
        return new Timestamp(date.getTime());
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Timestamp getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Timestamp postedDate) {
        this.postedDate = postedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
