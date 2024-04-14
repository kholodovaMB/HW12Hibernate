package org.HMB.dao;

import org.HMB.entity.Client;
import org.HMB.entity.Ticket;
import org.HMB.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

public class TicketCrudService {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public boolean saveTicket(Ticket ticket) {
        boolean result = false;
        if (ticket.getClient() == null) {
            System.out.println("client must be not null");
           return result;
        }

        if (Objects.isNull(ticket.getClient().getId())) {
            System.out.println("id client must be not null");
            return result;
        }

        if (ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            System.out.println("planet not exist");
            return result;
        }
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(ticket);
            result = true;
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return result;
    }

    public boolean updateTicket(Ticket ticket) {
        boolean result = false;
        if (ticket.getClient() == null) {
            return result;
        }

        if (Objects.isNull(ticket.getClient().getId())) {
            return result;
        }

        if (ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            return result;
        }
        Transaction transaction = null;

        if (ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            return result;
        }

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return result;
    }

    public Ticket getTicketById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public List<Ticket> getAllTickets() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }

    public void deleteTicket(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Ticket existing = session.get(Ticket.class, id);
            session.remove(existing);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
    }
}
