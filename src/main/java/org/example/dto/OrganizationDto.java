package org.example.dto;

import org.example.dto.ContactDto;

import java.util.List;

public class OrganizationDto implements AbstractDto<Long> {
    private String name;
    private String address;
    private List<ContactDto> contacts;

    public OrganizationDto() {
    }

    public OrganizationDto(String name, String address, List<ContactDto> contacts) {
        this.name = name;
        this.address = address;
        this.contacts = contacts;
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

    public List<ContactDto> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDto> contacts) {
        this.contacts = contacts;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long aLong) {

    }
}
