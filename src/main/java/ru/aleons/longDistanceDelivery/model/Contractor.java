package ru.aleons.longDistanceDelivery.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "contractor")
public class Contractor extends User {

    public Contractor() {
    }

    public Contractor(String login, String password, String tel, double averageLevel) {
        super(login, password, tel, averageLevel);
    }
}
