package by.ayupov.dao.interfaces;

import by.ayupov.entity.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {

    /**
     * this method is needed to find user by name and use for registration
     * @param name
     * @return
     */
    User findUserByName(String name);

    /**
     *  this method is needed to pagination user on page
     * @param pageNumber
     * @param page
     * @return
     */
    List<User> paginationUser(int pageNumber, int page);

    /**
     * this method is needed to find user by surname
     * @param surname
     * @return
     */
    User findUserBySurname(String surname);

    /**
     * this method is needed to find user by email
     * @param email
     * @return
     */
    User findUserByEmail(String email);

    /**
     * this method is needed to find user by phone
     * @param phone
     * @return
     */
    User findUserByPhone(int phone);
}
