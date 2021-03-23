package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.SessionFactoryUtil;

import java.io.Serializable;

public class CrRepository<T, Id>{
    private Class<T> c;

    public CrRepository(Class<T> c) {
        this.c = c;
        SessionFactoryUtil.getInstance().addClass(c);
        System.out.println(c);
    }

    public T getById(Id id) {
        return (T) SessionFactoryUtil.getInstance().getSessionFactory().openSession().get(c, (Serializable) id);
    }

    public void save(T domain) {
        Session session = SessionFactoryUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(domain);
        transaction.commit();
        session.close();
    }
}
