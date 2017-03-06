package by.ayupov.services.impl;

import by.ayupov.dao.interfaces.PriceDao;
import by.ayupov.entity.Price;
import by.ayupov.services.interfaces.PriceService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link PriceService} interface
 *
 * @author Vadim Ayupov
 */
@Service
@Log
@Transactional
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceDao priceDao;

    @Override
    @Transactional
    public List<Price> paginationPrice(int pageNumber, int page) {
        return priceDao.paginationPrice(pageNumber, page);
    }

    @Override
    @Transactional
    public List<Price> getAll() {
        return priceDao.getAll();
    }

    @Override
    @Transactional
    public Price getEntityById(Integer id) {
        return priceDao.getEntityById(id);
    }

    @Override
    @Transactional
    public void add(Price entity) {
        priceDao.add(entity);
    }

    @Override
    @Transactional
    public void update(Price entity) {
        priceDao.update(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        priceDao.delete(id);
    }
}
