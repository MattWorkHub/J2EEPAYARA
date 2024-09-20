package org.example.service;


import jakarta.inject.Inject;
import org.example.dao.AbstractDao;
import org.example.dao.AbstractDaoImplementation;
import org.example.dto.AbstractDto;
import org.example.entity.AbstractEntity;


import java.util.List;


public abstract class AbstractServiceImplementation<T extends AbstractEntity<ID>, D extends AbstractDto<ID>, ID>
        implements AbstractService<T, D, ID> {

   /* public AbstractServiceImplementation() { This does not work because an empty constructor is not really needed, but it is needed
    }*/

    public AbstractServiceImplementation(AbstractDaoImplementation<T, ID> dao) {
        this.dao = dao;
    }

    @Inject
    protected AbstractDao<T, ID> dao;

    private Class<T> entityClass;
    private Class<D> dtoClass;


    @Override
    public abstract D findById(ID id);

    @Override
    public abstract List<D> findAll();

    @Override
    public abstract D save(D dto);

    @Override
    public abstract D update(ID id, D dto);

    @Override
    public void delete(ID id) {
        dao.delete(dao.findById(id));
    }
}/*protected AbstractDaoImplementation<T,ID> dao;
    protected Object mapper;

    private Class<T> entityClass;
    private Class<D> dtoClass;

    public AbstractServiceImplementation(AbstractDaoImplementation<T, ID> dao, Object mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public D findById(ID id){
        T entity = dao.findById(id);
        return ((OrganizationMapper) mapper).toDto(entity);

    }
    @Override
    public List<D> findAll(){
        return dao.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public D save(D dto){
        T entity = mapper.toEntity(dto);
        T entitySaved = dao.save(entity);
        return mapper.toDto(entitySaved);
    }
    @Override
    public D update(ID id, D dto){
        T entity = mapper.toEntity(dto);
        entity = dao.update(entity);
        return mapper.toDto(entity);
    }
    @Override
    public void delete(ID id){
        dao.delete(dao.findById(id));
    }*/
