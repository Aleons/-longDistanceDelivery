package ru.aleons.longDistanceDelivery.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "STATEMENT")
public class Statement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 40)
    private String type;
    @Column(length = 30)
    private Date date;
    @Column(length = 100)
    private String city;
    @Column(length = 1000)
    private String bounty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER")
    private User user;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
