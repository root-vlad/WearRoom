package app.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Footwear {

    @Id
    @GeneratedValue
    @Column(name="FOOTWEAR_ID")
    private long id;

    private String name;
    private String color;

    public Footwear(String color, String name){
        this.color = color;
        this.name = name;
    }
}
