package app.models;

import javax.persistence.Entity;

@Entity
public class Headwear extends Wear {
    public Headwear(){}
    public Headwear(String color, String name) {
        super(color, name);
    }
    public Headwear(String color, String name, UserWear userWear) {
        super(color, name, userWear);
    }
}
