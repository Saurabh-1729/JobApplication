package com.saurabh.FirstJobApp.Company;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saurabh.FirstJobApp.Job.Job;
import com.saurabh.FirstJobApp.Reviews.Reviews;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @JsonIgnore // Removes recursive call backs
//    This is for Database to know that there is one to many mapping
    @OneToMany(mappedBy = "company") // this mapped by tells there is a mapping between Job and Company by a field named
//    company in the Job Entity
    List<Job> jobs;

//    @JsonIgnore
    @OneToMany(mappedBy = "company")
    List<Reviews> reviews;

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }
}
