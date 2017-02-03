package by.ayupov.services.impl;

import by.ayupov.entity.Price;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl extends BaseServiceImpl<Price> {
    private static final Logger log = Logger.getLogger(PriceServiceImpl.class);
}
