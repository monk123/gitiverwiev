package by.ayupov.runner;


import by.ayupov.utill.HibernateUtil;
import org.hibernate.SessionFactory;

public class Runner {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    }
}
