package ru.aleons.longDistanceDelivery.dao;

import ru.aleons.longDistanceDelivery.model.Statement;
import ru.aleons.longDistanceDelivery.model.User;
import java.util.Date;

public interface StatementDAO {

    Statement findByStatements(User user);
    Statement findByStatements(Date date);
    Statement findByStatements(String city);
    Statement findByStatement(int id);
    void add(User user, String city, Date date);
    void del(int id);
    void update(Date date, String city);

}
