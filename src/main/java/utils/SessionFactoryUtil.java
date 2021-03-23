package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
    private static SessionFactoryUtil instance;
    private SessionFactory sessionFactory;
    private Configuration configuration;

    private SessionFactoryUtil() {
        this.configuration = new Configuration().configure();
        updateSessionFactory();
    }

    public static SessionFactoryUtil getInstance() {
        if (instance == null) {
            instance = new SessionFactoryUtil();
        }
        return instance;
    }

    private void updateSessionFactory() {
        try {
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void addClass(Class c) {
        configuration.addAnnotatedClass(c);
        updateSessionFactory();
    }
}
