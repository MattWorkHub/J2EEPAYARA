package org.example.dao;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.entity.Contact;

@ApplicationScoped
public class ContactDao extends AbstractDaoImplementation<Contact, Long> {

    public ContactDao() {
        super(Contact.class);
    }

    @PostConstruct
    public void init() {
    }
}
