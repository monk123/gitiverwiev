package by.ayupov.dao.interfaces;

import by.ayupov.entity.Price;

import java.util.List;

public interface PriceDao extends BaseDao<Price> {

    /**
     * this method is needed to pagination price on page
     * @param pageNumber
     * @param page
     * @return
     */
    List<Price> paginationPrice(int pageNumber, int page);
}
