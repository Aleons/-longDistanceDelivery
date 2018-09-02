package ru.aleons.longDistanceDelivery.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "KIND", discriminatorType = DiscriminatorType.STRING)
@Table(name = "USERS")
public abstract class User {
    @Id
    @Column(length = 60)
    private String login;
    @Column(length = 60,nullable = false)
    private String password;
    @Column(length = 50)
    private String tel;
    @Column(length = 5)
    private double averageLevel;

    @OneToMany
    private List<Statement> statements;

    public User() {

    }

    public User(String login, String password, String tel, double averageLevel) {
        this.tel = tel;
        this.averageLevel = averageLevel;
        if (login == null) throw new IllegalArgumentException("Error!!! login Value the Null");
        if (login.length()<3) throw new IllegalArgumentException("Error!!! login Value <3 ");
        this.login = login;
        if (password == null) throw new IllegalArgumentException("Error!!! password Value the Null");
        if (password.length()<7) throw new IllegalArgumentException("Error!!! password Value <7 ");
        try {
            MessageDigest m=MessageDigest.getInstance("MD5");
            m.update(password.getBytes(),0,password.length());
            this.password = new BigInteger(1,m.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login == null) throw new IllegalArgumentException("Error!!! login Value the Null");
        if (login.length()<3) throw new IllegalArgumentException("Error!!! login Value <3 ");
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) throw new IllegalArgumentException("Error!!! password Value the Null");
        if (password.length()<7) throw new IllegalArgumentException("Error!!! password Value <7 ");
        try {
            MessageDigest m=MessageDigest.getInstance("MD5");
            m.update(password.getBytes(),0,password.length());
            this.password = new BigInteger(1,m.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
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

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }
}
