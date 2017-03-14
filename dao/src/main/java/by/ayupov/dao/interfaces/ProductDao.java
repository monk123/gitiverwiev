package by.ayupov.dao.interfaces;

import by.ayupov.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductDao extends BaseDao<Product>{

    /**
     * this method is needed to pagination product on page
     * @param firstResult
     * @param maxResult
     * @return
     */
    List<Product> paginationProduct(int firstResult, int maxResult);

    /**
     * this method is needed to pagination product if you have category
     * @param number
     * @param firstResult
     * @param maxResult
     * @return
     */
    List<Product> getPaginationProductByCategory(int number, int firstResult, int maxResult);

    /**
     * this method is needed to find product by category
     * @return
     */
    List<Product> findProductByCategory();
}
