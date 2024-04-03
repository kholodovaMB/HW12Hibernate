package org.HMB.dao;

import org.HMB.entity.Client;
import org.HMB.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

public class ClientCrudService {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    public boolean saveClient(Client client) {
        boolean result = false;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
            result = true;
        } catch(Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return result;
    }

    public Client findClientById(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }

    public boolean updateClient(Client client) {
        boolean result = false;
        if (Objects.isNull(client.getId())) {
            return result;
        }
            Transaction transaction = null;
            try (Session session = sessionFactory.openSession()) {
                transaction = session.beginTransaction();
                session.update(client);
                result = true;
                transaction.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
            }
        return result;
    }

    public void deleteClientById(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Client existing = session.get(Client.class, id);
            session.remove(existing);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
    }

    public List<Client> getAllClient() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }
}
