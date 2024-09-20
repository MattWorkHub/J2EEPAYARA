package org.example.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.dto.ContactDto;
import org.example.entity.Contact;
import org.example.service.AbstractServiceImplementation;

@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactController extends AbstractController<Contact, ContactDto, Long> {
    @Inject
    public ContactController(AbstractServiceImplementation service) {
        super(service);
    }


    @Override
    protected Long parseId(String idStr) {
        try {
            return Long.parseLong(idStr);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
