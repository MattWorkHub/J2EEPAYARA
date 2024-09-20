package org.example.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.dao.AbstractDao;
import org.example.dao.AbstractDaoImplementation;
import org.example.dao.ContactDao;
import org.example.dto.ContactDto;
import org.example.entity.Contact;
import org.example.mapper.ContactMapper;


import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ContactService extends AbstractServiceImplementation<Contact, ContactDto, Long> {

    @Inject
    private ContactMapper mapper;
    @Inject
    private AbstractDao<Contact, Long> dao;

    @Inject
    private ContactService(ContactDao dao, ContactMapper mapper) {
        super(dao);
        this.dao = dao;
        this.mapper = mapper;
    }

    public ContactService(AbstractDaoImplementation<Contact, Long> dao) {
        super(dao);
    }

    @Override
    public ContactDto findById(Long aLong) {
        Contact entity = dao.findById(aLong);
        return mapper.toDto(entity);
    }

    @Override
    public List<ContactDto> findAll() {
        return dao.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto save(ContactDto dto) {
        Contact entity = mapper.toEntity(dto);
        Contact saved = dao.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public ContactDto update(Long aLong, ContactDto dto) {
        Contact entity = mapper.toEntity(dto);
        entity = dao.update(entity);
        return mapper.toDto(entity);
    }
}
