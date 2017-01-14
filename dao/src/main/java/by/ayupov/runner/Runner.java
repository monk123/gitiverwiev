package by.ayupov.runner;

import by.ayupov.dao.UserDaoImpl;
import by.ayupov.entity.User;

public class Runner {

    public static void main(String[] args) {

        User user = new User();
        user.setName("Pavel");
        user.setSurname("Ayupov");
        user.setEmail("ayupov90.minsk@gmail.com");
        user.setCountry("Belarus");
        user.setRegion("Minsk region");
        user.setCity("Minsk");
        user.setAddress("Khiril Thurovsky 10");
        user.setPhone_number(7474128);

        UserDaoImpl userDao1 = new UserDaoImpl();
        userDao1.add(user);
    }
}
