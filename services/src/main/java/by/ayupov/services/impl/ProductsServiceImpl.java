package by.ayupov.services.impl;

import by.ayupov.dao.interfaces.ProductDao;
import by.ayupov.entity.Product;
import by.ayupov.services.interfaces.ProductRepository;
import by.ayupov.services.interfaces.ProductService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
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
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> paginationProduct(int firstResult, int maxResult) {
        return productsDao.paginationProduct(firstResult, maxResult);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getPaginationProductByCategory(int number, int firstResult, int maxResult) {
        return this.productsDao.getPaginationProductByCategory(number, firstResult, maxResult);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productsDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public List<Product> findProductByCategory() {
        return productsDao.findProductByCategory();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> findAllByPage(Integer pageable) {
        PageRequest request =
                new PageRequest(pageable - 1, 2, Sort.Direction.DESC, "startTime");
        return productRepository.findAll(request);
    }
}
