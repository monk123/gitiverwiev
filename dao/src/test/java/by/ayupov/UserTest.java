package by.ayupov;

import by.ayupov.crud.impl.UserDaoImpl;
import by.ayupov.entity.User;
import by.ayupov.exceptions.DaoException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class UserTest extends TestCase {

    private static UserDaoImpl<User> userDao = new UserDaoImpl<User>();
    private static User user = new User();

    @Test
    public void testAdd() throws DaoException {
        testGetByUser();
        Assert.assertEquals(7474128, user.getPhone_number());
    }

    @Test
    public void testGetAll() throws DaoException {
        testGetByUser();
        List<User> list = userDao.getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testGetEntityById() throws DaoException {
        testGetByUser();
        User user = userDao.getEntityById(1L);
        Assert.assertNotNull(user);
    }

    @Test
    public void testDelete() {

    }

    public static void testGetByUser() throws DaoException {
        user.setName("Vadim");
        user.setSurname("Ayupov");
        user.setEmail("ayub94.minsk@gmail.com");
        user.setCountry("Belarus");
        user.setRegion("Minsk region");
        user.setCity("Minsk");
        user.setAddress("Khirill Thurovsky 10");
        user.setPhone_number(7474128);
        userDao.add(user);
    }
}
