package by.ayupov;

import by.ayupov.dao.impl.UserDaoImpl;
import by.ayupov.entity.Category;
import by.ayupov.entity.Order;
import by.ayupov.entity.User;
import by.ayupov.exceptions.DaoException;
import junit.framework.TestCase;
import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;


public class UserTest extends TestCase {

    private static UserDaoImpl<User> userDao = new UserDaoImpl<>();
    private static User user = new User();

    @BeforeClass
    public void testUser() throws DaoException {
        user.setName("Vadim");
        user.setSurname("Ayupov");
        user.setCountry("Belarus");
        user.setRegion("Minsk region");
        user.setCity("Minsk");
        user.setAddress("Khirill Thurovsky 10");
        user.setEmail("ayub94.mogilev@gmail.com");
        user.setPhone_number(7474128);
        userDao.add(user);
    }

    @Test
    public void testGetAll() throws DaoException {
        testUser();
        List<User> userList = userDao.getAll();
        Assert.assertNotNull(userList);
    }

    @Test
    public void testGetEntityById() throws DaoException {
        testUser();
        User user1 = userDao.getEntityById(1L);
        Assert.assertEquals(user1.getUserId(),new Long(1L));
        Assert.assertNotNull(user1);
    }

    @Test
    public void testAdd() throws DaoException {
        testUser();
        Assert.assertNotNull(userDao.getEntityById(1L));
    }

    @Test
    public void testUpdate() throws DaoException {
        testUser();
        Assert.assertNotNull(userDao.getEntityById(1L));
        user.setRegion("Brest region");
        userDao.update(user);
    }

    @Test
    public void testDelete() throws DaoException {
        testUser();
        Assert.assertNotNull(userDao.getEntityById(1L));
        userDao.delete(1l);
        Assert.assertNull(userDao.getEntityById(1l));
    }
}