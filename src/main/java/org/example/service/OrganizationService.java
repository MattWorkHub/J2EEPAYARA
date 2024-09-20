package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.dao.AbstractDao;
import org.example.dao.OrganizationDao;
import org.example.dto.OrganizationDto;
import org.example.entity.Organization;
import org.example.mapper.OrganizationMapper;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrganizationService extends AbstractServiceImplementation<Organization, OrganizationDto,Long> {

    @Inject
    private OrganizationMapper mapper;
    @Inject
    private AbstractDao<Organization, Long> dao;

    @Inject
    private OrganizationService(OrganizationDao dao,OrganizationMapper mapper) {
        super(dao);
        this.dao = dao;
        this.mapper = mapper;
    };

    @Override
    public OrganizationDto findById(Long aLong) {
        Organization entity = dao.findById(aLong);
        return mapper.toDto(entity);
    }

    @Override
    public List<OrganizationDto> findAll() {
        return dao.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrganizationDto save(OrganizationDto dto) {
        Organization entity = mapper.toEntity(dto);
        Organization savedEntity = dao.save(entity);
        return mapper.toDto(savedEntity);
    }

    @Override
    public OrganizationDto update(Long aLong, OrganizationDto dto) {
        Organization entity = mapper.toEntity(dto);
        entity = dao.update(entity);
        return mapper.toDto(entity);
    }
}
