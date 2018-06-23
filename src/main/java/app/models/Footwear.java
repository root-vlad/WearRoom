package app.models;

import javax.persistence.Entity;

@Entity
public class Footwear extends Wear {
    public Footwear() {}
    public Footwear(String color, String name) {
        super(color, name);
    }
}
