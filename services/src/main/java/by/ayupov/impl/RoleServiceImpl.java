package by.ayupov.impl;

import by.ayupov.RoleService;
import by.ayupov.crud.impl.RoleDaoImpl;
import by.ayupov.exceptions.DaoException;
import java.util.List;

public class RoleServiceImpl<T> implements RoleService<T> {
    private RoleDaoImpl<T> roleDao;

    public List<T> getAll() throws DaoException {
        return roleDao.getAll();
    }

    public T getEntityById(Long id) throws DaoException {
        return roleDao.getEntityById(id);
    }

    public void add(T entity) throws DaoException {
        roleDao.add(entity);
    }

    public void update(T entity) throws DaoException {
        roleDao.update(entity);
    }

    public void delete(Long id) throws DaoException {
        roleDao.delete(id);
    }
}
