package ru.aleons.longDistanceDelivery.impl;

import ru.aleons.longDistanceDelivery.dao.StatementDAO;
import ru.aleons.longDistanceDelivery.model.Statement;
import ru.aleons.longDistanceDelivery.model.User;

import java.util.Date;

public class StatementDAOImpl implements StatementDAO {
    @Override
    public Statement findByStatements(User user) {
        return null;
    }

    @Override
    public Statement findByStatements(Date date) {
        return null;
    }

    @Override
    public Statement findByStatements(String city) {
        return null;
    }

    @Override
    public Statement findByStatement(int id) {
        return null;
    }

    @Override
    public void add(User user, String city, Date date) {

    }

    @Override
    public void del(int id) {

    }

    @Override
    public void update(Date date, String city) {

    }

}
