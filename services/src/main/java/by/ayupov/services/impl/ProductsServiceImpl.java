package by.ayupov.services.impl;

import by.ayupov.dao.interfaces.ProductDao;
import by.ayupov.entity.Product;
import by.ayupov.services.interfaces.ProductService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link ProductService} interface
 *
 * @author Vadim Ayupov
 */
@Service("productService")
@Log
@Transactional
public class ProductsServiceImpl implements ProductService{

    @Autowired
    private ProductDao productsDao;

    @Override
    @Transactional
    public List<Product> paginationProduct(int firstResult, int maxResult) {
        return productsDao.paginationProduct(firstResult, maxResult);
    }

    @Override
    public List<Product> getPaginationProductByCategory(String categoryName, int firstResult, int maxResult) {
        return this.productsDao.getPaginationProductByCategory(categoryName, firstResult, maxResult);
    }

    @Override
    @Transactional
    public List<Product> getAll() {
        return productsDao.getAll();
    }

    @Override
    @Transactional
    public Product getEntityById(Integer id) {
        return productsDao.getEntityById(id);
    }

    @Override
    @Transactional
    public void add(Product entity) {
        productsDao.add(entity);
    }

    @Override
    @Transactional
    public void update(Product entity) {
        productsDao.update(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        productsDao.delete(id);
    }

    @Override
    public List<Product> findProductByCategory() {
        return productsDao.findProductByCategory();
    }
}
