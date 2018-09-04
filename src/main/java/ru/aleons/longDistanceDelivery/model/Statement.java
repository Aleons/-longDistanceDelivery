package ru.aleons.longDistanceDelivery.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@Table(name = "STATEMENT")
public abstract class Statement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 40)
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

    public Statement(User user, Date date, String city, String bounty) {
        this.user = user;
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
