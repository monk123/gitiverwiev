package by.ayupov.services.impl;

import by.ayupov.dao.interfaces.RoleDao;
import by.ayupov.entity.Role;
import by.ayupov.services.interfaces.RoleService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link RoleService} interface
 *
 * @author Vadim Ayupov
 */
@Service
@Log
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional
    public List<Role> getAll() {
        return roleDao.getAll();
    }

    @Override
    @Transactional
    public Role getEntityById(Integer id) {
        return roleDao.getEntityById(id);
    }

    @Override
    @Transactional
    public void add(Role entity) {
        roleDao.add(entity);
    }

    @Override
    @Transactional
    public void update(Role entity) {
        roleDao.update(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        roleDao.delete(id);
    }
}
