package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public abstract class AbstractDaoImplementation<T, ID> implements AbstractDao<T, ID> {
    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> entityType;

    public AbstractDaoImplementation(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Override
    public T findById(ID id) {
        return entityManager.find(entityType, id);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("FROM " + entityType.getName(), entityType).getResultList();
    }

    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }
}
