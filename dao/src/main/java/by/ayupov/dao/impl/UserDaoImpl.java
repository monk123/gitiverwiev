package by.ayupov.dao.impl;

import by.ayupov.entity.User;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

@NoArgsConstructor
public class UserDaoImpl extends BaseDaoImpl<User> {
    private static final Logger log = Logger.getLogger(UserDaoImpl.class);
    private static UserDaoImpl userDao;

    public static UserDaoImpl getInstance() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }
}

