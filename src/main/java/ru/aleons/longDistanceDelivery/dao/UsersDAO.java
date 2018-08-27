package ru.aleons.longDistanceDelivery.dao;

import ru.aleons.longDistanceDelivery.model.User;

public interface UsersDAO {

    User findByLogin(String login);
    void add(String login, String password, String role);
    void update(String currentPassword, String newPassword);
    void complement(String tel);
    void estimate (double averageLevel);

}
