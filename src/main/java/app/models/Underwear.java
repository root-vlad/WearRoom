package app.models;

import javax.persistence.Entity;

@Entity
public class Underwear extends Wear{
    public Underwear(){}
    public Underwear(String color, String name) {
        super(color, name);
    }
}
