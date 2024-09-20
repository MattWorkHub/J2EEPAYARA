package org.example.service;

import org.example.dto.AbstractDto;
import org.example.entity.AbstractEntity;

import java.util.List;

public interface AbstractService<T extends AbstractEntity<ID>, D extends AbstractDto<ID>, ID> {
    D findById(ID id);

    List<D> findAll();

    D save(D dto);

    D update(ID id, D dto);

    void delete(ID id);
}
