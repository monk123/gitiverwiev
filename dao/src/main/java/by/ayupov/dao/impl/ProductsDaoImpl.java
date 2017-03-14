package by.ayupov.dao.impl;

import by.ayupov.dao.interfaces.ProductDao;
import by.ayupov.dao.interfaces.ProductRepository;
import by.ayupov.entity.Product;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of {@link ProductDao} interface
 *
 * @author Vadim Ayupov
 */
@Repository
@Log
public class ProductsDaoImpl implements ProductDao {
    private SessionFactory sessionFactory;
    private ProductRepository productRepository;

    @Autowired
    public ProductsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Product> paginationProduct(int firstResult, int maxResult) {
        return currentSession()
                .createQuery("from Product")
                .setFirstResult(firstResult)
                .setMaxResults(maxResult)
                .list();
    }

    @Override
    public List<Product> getAll() {
        return currentSession().createQuery("from Product").list();
    }

    @Override
    public Product getEntityById(Integer id) {
        return currentSession().get(Product.class, id);
    }

    @Override
    public void add(Product entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void update(Product entity) {
        currentSession().update(entity);
    }

    @Override
    public void delete(Integer id) {
        Product product = (Product) currentSession().get(Product.class, id);
        if (product != null) currentSession().delete(product);
    }

    public List<Product> getPaginationProductByCategory(int number, int firstResult, int maxResult) {
       return currentSession().createQuery("from Product p where p.categoryNumber=:number")
                .setParameter("number", number)
                .setFirstResult(firstResult)
                .setMaxResults(maxResult)
                .list();
    }

    @Override
    public List<Product> findProductByCategory() {
        return currentSession().createQuery("select distinct p.categoryNumber from Product p").list();
    }
}
