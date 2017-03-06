package by.ayupov.services.impl;

import by.ayupov.dao.interfaces.AddressDao;
import by.ayupov.entity.Address;
import by.ayupov.services.interfaces.AddressService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link AddressService} interface
 *
 * @author Vadim Ayupov
 */
@Service
@Log
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    @Transactional
    public List<String> findCityByUser(String name) {
       return addressDao.findCityByUser(name);
    }

    @Override
    @Transactional
    public List<String> findCountryByUser(String name) {
        return addressDao.findCountryByUser(name);
    }

    @Override
    @Transactional
    public List<String> findRegionByUser(String name) {
        return addressDao.findRegionByUser(name);
    }

    @Override
    @Transactional
    public List<String> findAddressByUser(String name) {
        return addressDao.findAddressByUser(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Address> paginationAddress(int pageNumber, int page) {
        return addressDao.paginationAddress(pageNumber, page);
    }

    @Override
    @Transactional
    public List<Address> getAll() {
        return addressDao.getAll();
    }

    @Override
    @Transactional
    public Address getEntityById(Integer id) {
        return addressDao.getEntityById(id);
    }

    @Override
    @Transactional
    public void add(Address entity) {
        addressDao.add(entity);
    }

    @Override
    @Transactional
    public void update(Address entity) {
        addressDao.update(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        addressDao.delete(id);
    }
}
