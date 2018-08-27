package ru.aleons.longDistanceDelivery.model;

import java.util.Date;

public class Statement {

    private User user;
    private String type;
    private Date date;
    private String city;
    private String bounty;

    public Statement() {

    }

    public Statement(User user, String type, Date date, String city, String bounty) {
        this.user = user;
        this.type = type;
        this.date = date;
        this.city = city;
        this.bounty = bounty;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBounty() {
        return bounty;
    }

    public void setBounty(String bounty) {
        this.bounty = bounty;
    }
}
