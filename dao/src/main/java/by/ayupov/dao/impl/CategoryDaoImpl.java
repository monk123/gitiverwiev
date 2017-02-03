package by.ayupov.dao.impl;

import by.ayupov.dao.interfaces.BaseDao;
import by.ayupov.entity.Category;
import by.ayupov.util.HibernateSessionFactory;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import java.util.List;

@NoArgsConstructor
public class CategoryDaoImpl extends BaseDaoImpl<Category> {
    private static final Logger log = Logger.getLogger(CategoryDaoImpl.class);
    private static CategoryDaoImpl categoryDao;

    public static CategoryDaoImpl getInstance() {
        if (categoryDao == null) {
            categoryDao = new CategoryDaoImpl();
        }
        return categoryDao;
    }
}
