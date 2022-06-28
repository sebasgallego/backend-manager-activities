package com.gallego.manager.ctivities.activity.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "activities")
public class Activity {
    @Id
    private String id;
    private String name;

    private String employees_id;

    private String name_employed;

    private int status_id;
    private int delay_days;
    private String status;

    private String start_date;

    public int getDelay_days() {
        return delay_days;
    }

    public void setDelay_days(int delay_days) {
        this.delay_days = delay_days;
    }

    public String getName_employed() {
        return name_employed;
    }

    public void setName_employed(String name_employed) {
        this.name_employed = name_employed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployees_id() {
        return employees_id;
    }

    public void setEmployees_id(String employees_id) {
        this.employees_id = employees_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }
}
