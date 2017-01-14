package by.ayupov.dao;

import by.ayupov.entity.User;
import by.ayupov.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class UserDaoImpl implements UserDao<User, Long> {

    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    private Session currentSession;
    private SessionFactory sessionFactory;

    public UserDaoImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        currentSession = sessionFactory.getCurrentSession();
        List<User> userList = currentSession.createQuery("select from users").list();

        for (User user:userList) {
            logger.info("User list: " + user);
        }

        return userList;
    }

    public User getEntityById(Long id) {
        currentSession = sessionFactory.getCurrentSession();
        User user = (User) currentSession.load(User.class, new Long(id));
        logger.info("User successfully loaded. User datails: " + user);

        return user;
    }

    public void add(User entity) {
        currentSession = this.sessionFactory.getCurrentSession();
        currentSession.persist(entity);
        logger.info("User successfully saved. User datails: " + entity);

        /*sessionFactory = HibernateUtil.getSessionFactory();
        currentSession = sessionFactory.openSession();
        currentSession.beginTransaction();
        currentSession.save(entity);
        currentSession.getTransaction().commit();*/
    }

    public void update(User entity) {
        currentSession = sessionFactory.getCurrentSession();
        currentSession.update(entity);
        logger.info("User successfully update. User details: " + entity);
    }

    public void delete(Long id) {
        currentSession = sessionFactory.getCurrentSession();
        User user = (User) currentSession.load(User.class, new Long(id));

        if (user != null) {
            currentSession.delete(user);
        }

        logger.info("User successfully delete. User details: " + user);
    }


}

