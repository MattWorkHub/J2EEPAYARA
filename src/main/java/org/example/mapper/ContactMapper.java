package org.example.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.dto.ContactDto;
import org.example.entity.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ContactMapper {
    ContactDto toDto(Contact contact);

    Contact toEntity(ContactDto contactDto);

    default Long map(Object value) {
        if (value instanceof Long) {
            return (Long) value;
        }
        return null;
    }
}
