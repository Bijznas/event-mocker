package com.event.mocker.entities;

import com.event.mocker.enums.ProcessType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sanjib on 2/4/17.
 */
@Entity
@Table(name = "process")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Process implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProcessType type;

    private Date dateCreated;

    private Date lastUpdated;

    @NotNull
    @Column(nullable = false)
    private String status = "Running";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProcessType getType() {
        return type;
    }

    public void setType(ProcessType type) {
        this.type = type;
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
