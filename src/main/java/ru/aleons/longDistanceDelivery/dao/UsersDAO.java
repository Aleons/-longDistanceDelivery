package ru.aleons.longDistanceDelivery.dao;

import ru.aleons.longDistanceDelivery.model.User;

public interface UsersDAO {

    User findByLogin(String login);
    void add(User user);
    void delete(User user);
    void update(String login, User newUser);
    void complement(User user, String tel);
    void estimate (User user, double averageLevel);

}
