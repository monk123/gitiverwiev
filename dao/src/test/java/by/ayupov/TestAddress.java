package by.ayupov;

import by.ayupov.dao.impl.AddressDaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

public class TestAddress {
    private AddressDaoImpl addressDao;
    private SessionFactory sessionFactory;

    @Test
    public void testFindCityByUser() {
        addressDao = new AddressDaoImpl(sessionFactory);
        Session session = addressDao.currentSession();
        //session.beginTransaction();
        addressDao.findCityByUser("Вадим");
      //  session.getTransaction().commit();
    }

    @Test
    public void testFindRegionByUser()  {
        addressDao = new AddressDaoImpl(sessionFactory);
        Session session = addressDao.currentSession();
       // session.beginTransaction();
        addressDao.findRegionByUser("Вадим");
      //  session.getTransaction().commit();
    }

    @Test
    public void testFindCountryByUser() {
        addressDao = new AddressDaoImpl(sessionFactory);
        Session session = addressDao.currentSession();
      //  session.beginTransaction();
        addressDao.findCountryByUser("Александр");
     //   session.getTransaction().commit();
    }

    @Test
    public void testFindAddressByUser(){
        addressDao = new AddressDaoImpl(sessionFactory);
        Session session = addressDao.currentSession();
       // session.beginTransaction();
        addressDao.findAddressByUser("Анна");
      //  session.getTransaction().commit();
    }

    @Test
    public void testPaginationAddress(){
        Session session = addressDao.currentSession();
      //  session.beginTransaction();
        addressDao.paginationAddress(1, 5);
     //   session.getTransaction().commit();
    }
}
