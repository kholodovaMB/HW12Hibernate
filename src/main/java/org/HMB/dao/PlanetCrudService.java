package org.HMB.dao;

import org.HMB.entity.Planet;
import org.HMB.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class PlanetCrudService {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    public boolean savePlanet(Planet planet) {
        boolean result = false;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
            result = true;
        } catch(Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return result;
    }

    public Planet findPlanetById(String id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public boolean updatePlanet(Planet planet) {
        boolean result = false;
        if (Objects.isNull(planet.getId())) {
            return result;
        }
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(planet);
            result = true;
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return result;
    }

    public void deletePlanetById(String id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Planet existing = session.get(Planet.class, id);
            session.remove(existing);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
    }

    public List<Planet> getAllPlanets() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }
}
