package by.ayupov.services.impl;

import by.ayupov.entity.Category;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category> {
    private static final Logger log = Logger.getLogger(CategoryServiceImpl.class);
}
