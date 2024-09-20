package org.example.dto;


public class ContactDto implements AbstractDto<Long> {
    private String name;
    private String job;
    private OrganizationDto organization;

    public ContactDto() {
    }

    public ContactDto(String name, String job, OrganizationDto organization) {
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

    public void setJob(String address) {
        this.job = address;
    }

    public OrganizationDto getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDto organization) {
        this.organization = organization;
    }


    @Override
    public Long getId() {
        return 0L;
    }

    @Override
    public void setId(Long aLong) {

    }
}
