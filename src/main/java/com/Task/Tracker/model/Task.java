package com.Task.Tracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
private String createdBy;
private LocalDate date;
private LocalTime time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String Title;

    public Task(long id, String createdBy, LocalDate date, LocalTime time, String title, String description, Status status, String assignedTo) {
        this.id = id;
        this.createdBy = createdBy;
        this.date = date;
        this.time = time;
        Title = title;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
    }

    private String description;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Task() {
    }



    @Enumerated(EnumType.STRING)
    private Status status;
private String assignedTo;



    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}
