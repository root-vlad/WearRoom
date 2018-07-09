package app.models;

import javax.persistence.Entity;

@Entity
public class Underwear extends Wear{
    public Underwear(){}
    public Underwear(String color, String name, UserWear userWear) {
        super(color, name, userWear);
    }
}
