package by.ayupov.services.impl;

import by.ayupov.dao.interfaces.UserDao;
import by.ayupov.entity.User;
import by.ayupov.services.interfaces.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link UserService} interface
 *
 * @author Vadim Ayupov
 */
@Service
@Log
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    @Transactional
    public List<User> paginationUser(int pageNumber, int page) {
        return userDao.paginationUser(pageNumber, page);
    }

    @Override
    @Transactional
    public User findUserBySurname(String surname) {
        return userDao.findUserBySurname(surname);
    }

    @Override
    @Transactional
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    @Transactional
    public User findUserByPhone(int phone) {
        return userDao.findUserByPhone(phone);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getEntityById(Integer id) {
        return userDao.getEntityById(id);
    }

    @Override
    public void add(User entity) {
        userDao.add(entity);
    }

    @Override
    public void update(User entity) {
        userDao.update(entity);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }
}
