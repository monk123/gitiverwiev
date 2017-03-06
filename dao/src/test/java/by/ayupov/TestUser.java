package by.ayupov;

import by.ayupov.dao.impl.UserDaoImpl;
import by.ayupov.entity.User;
import lombok.extern.java.Log;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static org.junit.Assert.*;

@Log
@ContextConfiguration("/spring-dao-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestUser {

    @Autowired
    private UserDaoImpl userDaoImpl;

    public User initUser() {
        User user = new User();
        user.setId(9);
        user.setName("Вадим");
        user.setSurname("Аюпов");
        user.setEmail("ayub94.minsk@gmail.com");
        user.setPhoneNumber(7474128);
        return user;
    }

    @Test
    public void addUser() {
        User user = initUser();
        userDaoImpl.add(user);
    }

  @After
    public void testDelete() {
        List<User> list = userDaoImpl.getAll();
        int size = list.size();
        if (list.size() > 0) {
          User user = list.get(0);
          userDaoImpl.delete(user.getId());
          assertNotSame(userDaoImpl.getAll().size(), size);
        }
    }

    @Test
    public void testFindUserByName(){
        User user = initUser();
        userDaoImpl.add(user);
        log.info("User: ");
        User testUser = userDaoImpl.findUserByName(user.getName());
        log.info("Test user: " + testUser);
        assertEquals(user, testUser);
    }

    @Test
    public void testFindUserAll() {
        User user = initUser();
        userDaoImpl.add(user);
        log.info("User: " + user);
        assertNotNull(user);
        User testUser = userDaoImpl.findUserByEmail(user.getEmail());
        log.info("Test user email: " + testUser.getEmail());
        assertEquals(user.getEmail(), testUser.getEmail());
        testUser = userDaoImpl.findUserBySurname(user.getSurname());
        log.info("Test user surname: " + testUser.getSurname());
        assertEquals(user.getSurname(), testUser.getSurname());
        testUser = userDaoImpl.findUserByPhone(user.getPhoneNumber());
        log.info("Test user phone: " + testUser.getPhoneNumber());
        assertEquals(user.getPhoneNumber(), testUser.getPhoneNumber());
    }
}