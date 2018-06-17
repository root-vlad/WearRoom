package app.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Outerwear {
    @Id
    @GeneratedValue
    @Column(name="OUTERWEAR_ID")
    private long id;


    private String name;
    private String color;

    public Outerwear(String color, String name){
        this.color = color;
        this.name = name;
    }
}
