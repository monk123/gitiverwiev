package by.ayupov.dao.impl;

import by.ayupov.entity.Price;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;


@NoArgsConstructor
public class PriceDaoImpl extends BaseDaoImpl<Price> {
    private static final Logger log = Logger.getLogger(PriceDaoImpl.class);
    private static PriceDaoImpl priceDao;

    public static PriceDaoImpl getInstance() {
        if (priceDao == null) {
            priceDao = new PriceDaoImpl();
        }

        return priceDao;
    }
}
