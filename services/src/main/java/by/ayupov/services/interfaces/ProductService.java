package by.ayupov.services.interfaces;

import by.ayupov.entity.Product;

import java.util.List;

public interface ProductService extends BaseService<Product> {

    /**
     * this method is needed to pagination product on page
     * @param firstResult
     * @param maxResult
     * @return
     */
    List<Product> paginationProduct(int firstResult, int maxResult);

    /**
     * this method is needed to pagination product by category
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
