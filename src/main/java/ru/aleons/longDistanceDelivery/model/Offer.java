package ru.aleons.longDistanceDelivery.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue(value = "offer")
public class Offer extends Statement {
    public Offer() {

    }

    public Offer(User user, Date date, String city, String bounty) {
        super(user,date, city, bounty);
    }
}
