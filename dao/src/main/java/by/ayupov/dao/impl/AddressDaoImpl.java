package by.ayupov.dao.impl;

import by.ayupov.dao.interfaces.AddressDao;
import by.ayupov.entity.Address;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of {@link AddressDao} interface
 *
 * @author Vadim Ayupov
 */
@Repository
@Log
public class AddressDaoImpl implements AddressDao {
    private SessionFactory sessionFactory;

    @Autowired
    public AddressDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session currentSession() {
         return sessionFactory.getCurrentSession();
     }

    @Override
    public List<String> findCityByUser(String name) {
         return currentSession().createQuery("select a.city from Address a where user.name=:name")
                 .setParameter("name", name)
                 .list();
     }

    @Override
    public List<String> findCountryByUser(String name) {
        return currentSession().createQuery("select a.country from Address a where user.name=:name")
                .setParameter("name", name)
                .list();
    }

    @Override
    public List<String> findRegionByUser(String name) {
        return currentSession().createQuery("select a.region from Address a where user.name=:name")
                .setParameter("name", name)
                .list();
    }

    @Override
    public List<String> findAddressByUser(String name) {
        return currentSession().createQuery("select a.address from Address a where user.name=:name")
                .setParameter("name", name)
                .list();
    }

    @Override
    public List<Address> paginationAddress(int pageNumber, int page) {
        return currentSession().createQuery("from Address ", Address.class)
                .setFirstResult(pageNumber)
                .setMaxResults(page)
                .list();
    }

    @Override
    public List<Address> getAll() {
        return currentSession().createQuery("from Address").list();
    }

    @Override
    public Address getEntityById(Integer id) {
        return currentSession().get(Address.class, id);
    }

    @Override
    public void add(Address entity) {
        currentSession().save(entity);
    }

    @Override
    public void update(Address entity) {
        currentSession().update(entity);
    }

    @Override
    public void delete(Integer id) {
        Address address = (Address) currentSession().get(Address.class, id);
        if (address != null) currentSession().delete(address);
    }
}

