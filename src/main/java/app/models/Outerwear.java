package app.models;

import javax.persistence.Entity;

@Entity
public class Outerwear extends Wear {
    public Outerwear(){}
    public Outerwear(String color, String name) {
        super(color, name);
    }
}
