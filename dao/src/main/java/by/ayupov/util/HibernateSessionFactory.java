package by.ayupov.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory {
    private static final Logger logger = Logger.getLogger(HibernateSessionFactory.class);
    private static ThreadLocal threadLocal = new ThreadLocal();
    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry standardRegistry =
                    new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(standardRegistry)
                    .buildMetadata()
                    .buildSessionFactory();
            return sessionFactory;
        }
        catch (Throwable ex) {
            logger.error("Initial SessionFactory creation failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        Session currentSession = (Session) threadLocal.get();
        if (currentSession == null) {
            currentSession = sessionFactory.openSession();
        }

        threadLocal.set(currentSession);

        return currentSession;
    }

}
