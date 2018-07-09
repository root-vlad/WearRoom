package app.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Footwear extends Wear {
    public Footwear() {}

    public Footwear(String color, String name, UserWear userWear) {
        super(color, name, userWear);
    }
}
