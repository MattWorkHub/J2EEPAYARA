package org.example.mapper;

import org.example.dto.OrganizationDto;
import org.example.entity.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface OrganizationMapper {
    OrganizationDto toDto(Organization organization);

    Organization toEntity(OrganizationDto organizationDto);

    default Long map(Object value) {
        if (value instanceof Long) {
            return (Long) value;
        }

        return null;
    }
}
