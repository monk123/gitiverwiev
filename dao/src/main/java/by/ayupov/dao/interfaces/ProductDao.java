package by.ayupov.dao.interfaces;

import by.ayupov.entity.Product;
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
     * @param categoryName
     * @param firstResult
     * @param maxResult
     * @return
     */
    List<Product> getPaginationProductByCategory(String categoryName, int firstResult, int maxResult);

    /**
     * this method is needed to find product by category
     * @return
     */
    List<Product> findProductByCategory();

}
