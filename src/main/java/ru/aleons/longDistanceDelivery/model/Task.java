package ru.aleons.longDistanceDelivery.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue(value = "task")
public class Task extends Statement{

    public Task() {
    }

    public Task(User user, Date date, String city, String bounty) {
        super(user, date, city, bounty);
    }
}
