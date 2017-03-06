package by.ayupov.services.impl;

import by.ayupov.dao.interfaces.CategoryDao;
import by.ayupov.entity.Category;
import by.ayupov.services.interfaces.CategoryService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link CategoryService} interface
 *
 * @author Vadim Ayupov
 */
@Service
@Log
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public List<Category> getAll() {
        return this.categoryDao.getAll();
    }

    @Override
    @Transactional
    public Category getEntityById(Integer id) {
        return categoryDao.getEntityById(id);
    }

    @Override
    @Transactional
    public void add(Category entity) {
        categoryDao.add(entity);
    }

    @Override
    @Transactional
    public void update(Category entity) {
        categoryDao.update(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        categoryDao.delete(id);
    }
}
