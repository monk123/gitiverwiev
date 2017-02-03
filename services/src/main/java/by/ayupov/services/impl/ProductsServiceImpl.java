package by.ayupov.services.impl;

import by.ayupov.entity.Product;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl extends BaseServiceImpl<Product> {
    private static final Logger log = Logger.getLogger(ProductsServiceImpl.class);
}
