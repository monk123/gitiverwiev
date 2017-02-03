package by.ayupov.services.impl;

import by.ayupov.dao.interfaces.BaseDao;
import by.ayupov.exception.DaoException;
import by.ayupov.services.interfaces.BaseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseServiceImpl<T> implements BaseService<T> {
    private static final Logger log = Logger.getLogger(BaseServiceImpl.class);

    @Autowired
    private BaseDao<T> baseDao;

    @Override
    public List<T> getAll() throws DaoException {
        return baseDao.getAll();
    }

    @Override
    public T getEntityById(Long id) throws DaoException {
        return baseDao.getEntityById(id);
    }

    @Override
    public void add(T entity) throws DaoException {
        baseDao.add(entity);
    }

    @Override
    public void update(T entity) throws DaoException {
        baseDao.update(entity);
    }

    @Override
    public void delete(Long id) throws DaoException {
        baseDao.delete(id);
    }
}
