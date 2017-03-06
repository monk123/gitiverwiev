package by.ayupov.dao.impl;

import by.ayupov.dao.interfaces.RoleDao;
import by.ayupov.entity.Role;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of {@link RoleDao} interface
 *
 * @author Vadim Ayupov
 */
@Repository
@Log
public class RoleDaoImpl implements RoleDao {
    private SessionFactory sessionFactory;

    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Role> getAll() {
        return currentSession().createQuery("from Role").list();
    }

    @Override
    public Role getEntityById(Integer id) {
        return currentSession().get(Role.class, id);
    }

    @Override
    public void add(Role entity) {
        currentSession().save(entity);
    }

    @Override
    public void update(Role entity) {
        currentSession().update(entity);
    }

    @Override
    public void delete(Integer id) {
        Role role = (Role) currentSession().get(Role.class, id);
        if (role != null) currentSession().delete(role);
    }
}
