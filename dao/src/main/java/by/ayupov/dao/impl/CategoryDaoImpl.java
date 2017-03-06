package by.ayupov.dao.impl;

import by.ayupov.dao.interfaces.CategoryDao;
import by.ayupov.entity.Category;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implemenation of {@link CategoryDao} interface
 *
 * @author Vadim Ayupov
 */
@Repository
@Log
public class CategoryDaoImpl implements CategoryDao{
    private SessionFactory sessionFactory;

    @Autowired
    public CategoryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Category> getAll() {
        return currentSession().createQuery("from Category ").list();
    }

    @Override
    public Category getEntityById(Integer id) {
        return currentSession().get(Category.class, id);
    }

    @Override
    public void add(Category entity) {
        currentSession().save(entity);
    }

    @Override
    public void update(Category entity) {
        currentSession().update(entity);
    }

    @Override
    public void delete(Integer id) {
        Category category = (Category) currentSession().get(Category.class, id);
        if (category != null) currentSession().delete(category);
    }
}
