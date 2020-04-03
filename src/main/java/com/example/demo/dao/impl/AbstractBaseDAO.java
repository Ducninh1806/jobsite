package com.example.demo.dao.impl;

import com.example.demo.dao.BaseDAO;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractBaseDAO implements BaseDAO {

    @Autowired
    private EntityManager entityManager;

    protected Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public <T> List<T> findAll(Class<T> clazz) {
        return getSession().createQuery("select t from " + clazz.getName() + " t", clazz).getResultList();
    }

    @Override
    public <T> Optional<T> findById(Serializable id, Class<T> clazz) {
        return Optional.ofNullable(getSession().get(clazz, id));
    }

    @Override
    public <T> Serializable save(T entity) {
        return getSession().save(entity);
    }

    @Override
    public <T> void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public <T> void delete(T entity) {
        getSession().delete(entity);
    }
}
