package com.event.mocker.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sanjib on 2/5/17.
 */
@Entity
@Table(name = "notification")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Notification implements Serializable{
    public Notification(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String title;

    private Date dateCreated;

    private Date lastUpdated;

    private String description;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="process_id")
    private Process process;

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @PreUpdate
    public void setLastUpdatedDate() {
        this.setLastUpdated(new Date());
    }

    @PrePersist
    public void setCreatedDate() {
        this.setLastUpdated(new Date());
        this.setDateCreated(new Date());
    }
}
