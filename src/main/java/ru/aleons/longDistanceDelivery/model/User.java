package ru.aleons.longDistanceDelivery.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

    private String login;
    private String password;
    private String role;
    private String tel;
    private double averageLevel;

    public User() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null) throw new IllegalArgumentException("");
        if (login.length()<3) throw new IllegalArgumentException("");
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) throw new IllegalArgumentException("");
        if (password.length()<7) throw new IllegalArgumentException("");
        try {
            MessageDigest m=MessageDigest.getInstance("MD5");
            m.update(password.getBytes(),0,password.length());
            this.password = new BigInteger(1,m.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (password == null) throw new IllegalArgumentException("");
        this.role = role;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public double getAverageLevel() {
        return averageLevel;
    }

    public void setAverageLevel(double averageLevel) {
        this.averageLevel = averageLevel;
    }
}
