package by.ayupov;

import by.ayupov.dao.impl.RatingDaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

public class TestRating {
    private RatingDaoImpl ratingDao;
    private SessionFactory sessionFactory;

    @Test
    public void testGetRatingMarks() {
       // ratingDao = new RatingDaoImpl(sessionFactory);
        Session session = ratingDao.currentSession();
       // session.beginTransaction();
        ratingDao.getRatingMarks("Xiaomi Redmi 4 32GB Silver");
      //  session.getTransaction().commit();
    }
}
