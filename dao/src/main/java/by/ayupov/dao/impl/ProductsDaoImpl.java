package by.ayupov.dao.impl;

import by.ayupov.dao.ProductsDao;
import by.ayupov.entity.Products;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

public class ProductsDaoImpl<Products> implements ProductsDao<Products> {

    private static final Logger logger = Logger.getLogger(ProductsDao.class);

    private SessionFactory sessionFactory;
    private Session currentSession;

    public List<Products> getAll() {
        return null;
    }

    public Products getEntityById(Long id) {
        return null;
    }

    public void add(Products entity) {

    }

    public void update(Products entity) {

    }

    public void delete(Long id) {

    }
}
