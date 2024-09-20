package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name ="contact")
@Entity
public class Contact extends AbstractEntity<Long> {
    private String name;
    private String job;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    // @JsonIgnoreProperties("contactList")
    private Organization organization;

    public Contact() {
    }

    public Contact(String name, String job, Organization organization) {
        this.name = name;
        this.job = job;
        this.organization = organization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
