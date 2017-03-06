package by.ayupov.services.interfaces;

import by.ayupov.entity.Price;

import java.util.List;

public interface PriceService extends BaseService<Price> {

    /**
     * this method is needed to pagination price on page
     * @param pageNumber
     * @param page
     * @return
     */
    List<Price> paginationPrice(int pageNumber, int page);
}
