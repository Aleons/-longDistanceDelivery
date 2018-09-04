package ru.aleons.longDistanceDelivery.impl;

import ru.aleons.longDistanceDelivery.dao.StatementDAO;
import ru.aleons.longDistanceDelivery.model.Statement;
import ru.aleons.longDistanceDelivery.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.Date;

public class StatementDAOImpl implements StatementDAO {

    private EntityManager em;

    public StatementDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Statement findByStatements(User user) {
        return em.find(Statement.class, user);
    }

    @Override
    public Statement findByStatements(Date date) {
        return em.find(Statement.class, date);
    }

    @Override
    public Statement findByStatements(String city) {
        return em.find(Statement.class, city);
    }

    @Override
    public Statement findByStatement(int id) {
        return em.find(Statement.class, id);

    }

    @Override
    public void add(User user, String city, Date date) {
        Statement statement = new Statement();
        statement.setUser(user);
        statement.setCity(city);
        statement.setDate(date);
        em.getTransaction().begin();
        try {
            em.persist(statement);
            em.getTransaction().commit();
        }
        catch (PersistenceException e){
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    @Override
    public void del(int id) {

    }

    @Override
    public void update(Date date, String city) {

    }

}
