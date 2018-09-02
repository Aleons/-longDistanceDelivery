package ru.aleons.longDistanceDelivery.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "customer")
public class Customer extends User {

    public Customer() {
    }

    public Customer(String login, String password, String tel, double averageLevel) {
        super(login, password, tel, averageLevel);
    }

}
