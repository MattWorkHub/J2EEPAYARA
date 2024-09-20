package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Table(name = "organization")
@Entity
public class Organization extends AbstractEntity<Long> {
    private String name;
    private String address;
    @OneToMany(mappedBy = "organization", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("organization")
    private List<Contact> contacts;

    public Organization() {
    }

    public Organization(String name, String address) {
        this.name = name;
        this.address = address;
        this.contacts = new ArrayList<>();
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

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
