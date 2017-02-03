package by.ayupov.dao.impl;

import by.ayupov.entity.Address;
import by.ayupov.exception.DaoException;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

@NoArgsConstructor
public class AddressDaoImpl extends BaseDaoImpl<Address> {
    private static final Logger log = Logger.getLogger(AddressDaoImpl.class);
    private static AddressDaoImpl addressDao;

    private static AddressDaoImpl getInstance() {
        if (addressDao == null) {
            addressDao = new AddressDaoImpl();
        }

        return addressDao;
    }
}
