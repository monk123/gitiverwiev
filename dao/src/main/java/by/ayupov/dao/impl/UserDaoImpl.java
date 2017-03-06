package by.ayupov.dao.impl;

import java.util.List;

import by.ayupov.dao.interfaces.UserDao;
import by.ayupov.entity.User;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementation of {@link UserDao} interface
 *
 * @author Vadim Ayupov
 */
@Repository
@Log
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User findUserByName(String name) {
        return (User) currentSession().createQuery("from User where name=:name")
                .setParameter("name", name)
                .uniqueResult();
    }

    @Override
    public List<User> paginationUser(int pageNumber, int page) {
        return currentSession().createQuery("from User", User.class)
                .setFirstResult(pageNumber)
                .setMaxResults(page)
                .list();
    }

    @Override
    public User findUserBySurname(String surname) {
        return (User) currentSession()
                .createQuery("select u from User u where u.surname=:surname")
                .setParameter("surname", surname)
                .uniqueResult();
    }

    @Override
    public User findUserByEmail(String email) {
        return (User) currentSession()
                .createQuery("select u from User u where u.email=:email")
                .setParameter("email", email)
                .uniqueResult();
    }

    @Override
    public User findUserByPhone(int phone) {
        return (User) currentSession()
                .createQuery("select u from User u where u.phoneNumber=:phone")
                .setParameter("phone", phone)
                .uniqueResult();
    }

    @Override
    public List<User> getAll() {
        return currentSession().createQuery("from User").list();
    }

    @Override
    public User getEntityById(Integer id) {
        User user = (User) currentSession().load(User.class, id);
        return user;
    }

    @Override
    public void add(User entity) {
        currentSession().save(entity);
    }

    @Override
    public void update(User entity) {
        currentSession().update(entity);
    }

    @Override
    public void delete(Integer id) {
        User user = (User) currentSession().get(User.class, id);
        if (user != null) currentSession().delete(user);
    }
}

