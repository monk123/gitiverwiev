package by.ayupov.dao.impl;

import by.ayupov.entity.Product;
import by.ayupov.exception.DaoException;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@NoArgsConstructor
public class ProductsDaoImpl extends BaseDaoImpl<Product> {
    private static final Logger log = Logger.getLogger(ProductsDaoImpl.class);
    private static ProductsDaoImpl productsDao;

    public static ProductsDaoImpl getInstance() {
        if (productsDao == null) {
            productsDao = new ProductsDaoImpl();
        }

        return productsDao;
    }

    public List<Product> pagintion(int pageNumber, int page) throws DaoException {
        try {
            Session session = getInstance().getSession();
            Query query = session.createQuery("from Product")
                    .setFirstResult(pageNumber)
                    .setMaxResults(page);
            List<Product> list = (List<Product>) query.list();

            if (list != null) list.forEach(product -> log.info("Pagination product: " + product));

            return list;
        } catch (HibernateException ex) {
            log.error("Error pagination Entity: " + ex);
            throw new DaoException(ex);
        }
    }
}
