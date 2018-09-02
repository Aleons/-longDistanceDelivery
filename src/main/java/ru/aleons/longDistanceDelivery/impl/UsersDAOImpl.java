package ru.aleons.longDistanceDelivery.impl;

import ru.aleons.longDistanceDelivery.dao.UsersDAO;
import ru.aleons.longDistanceDelivery.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class UsersDAOImpl implements UsersDAO {

    private EntityManager em;

    public UsersDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public User findByLogin(String login) {
        return em.find(User.class, login);
    }

    @Override
    public void add(User user) {
        em.getTransaction().begin();
        try {
            em.persist(user);
            em.getTransaction().commit();
        }
        catch (PersistenceException e){
            System.out.println(e);
            em.getTransaction().rollback();
        }

    }

    @Override
    public void update(User oldUser, User newUser) {
//        String _query = "update User set password = '"+newUser.getPassword()+"', " +
//                        "role = '"+newUser.getRole()+"', " +
//                        "tel = '"+newUser.getTel()+"'";
//        em.getTransaction().begin();
//        try {
//            if(em.find(User.class, oldUser.getLogin()).getLogin()!=null){
//                Query query = em.createQuery(_query);
//                query.executeUpdate();
//            }
//        }

    }

    @Override
    public void complement(User user, String tel) {

    }

    @Override
    public void estimate(User user, double averageLevel) {

    }
}
