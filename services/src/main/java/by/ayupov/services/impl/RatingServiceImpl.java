package by.ayupov.services.impl;

import by.ayupov.dao.interfaces.RatingDao;
import by.ayupov.entity.Rating;
import by.ayupov.services.interfaces.RatingService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link RatingService} interface
 *
 * @author Vadim Ayupov
 */
@Service
@Log
@Transactional
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingDao ratingDao;

    @Override
    @Transactional
    public List<Integer> getRatingMarks(String productName) {
        return ratingDao.getRatingMarks(productName);
    }

    @Override
    @Transactional
    public List<Rating> getAll() {
        return ratingDao.getAll();
    }

    @Override
    @Transactional
    public Rating getEntityById(Integer id) {
        return ratingDao.getEntityById(id);
    }

    @Override
    @Transactional
    public void add(Rating entity) {
        ratingDao.add(entity);
    }

    @Override
    @Transactional
    public void update(Rating entity) {
        ratingDao.update(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        ratingDao.delete(id);
    }
}
