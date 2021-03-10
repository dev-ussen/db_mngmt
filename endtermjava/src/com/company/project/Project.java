package com.company.project;

import java.sql.Date;

//class Project used to get access to project information easier
//single responsibility
public class Project {
    private int project_id;
    private String discription;
    private Date deadline;


    public Project(int project_id) {
        this.project_id = project_id;
    }


    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
