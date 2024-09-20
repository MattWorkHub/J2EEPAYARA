package org.example.dao;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.entity.Organization;

@ApplicationScoped
public class OrganizationDao extends AbstractDaoImplementation<Organization,Long> {

    public OrganizationDao() {
        super(Organization.class);
    }

    @PostConstruct
    public void init() {}
}
