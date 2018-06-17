package app.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Underwear {

    @Id
    @GeneratedValue
    @Column(name="UNDERWEAR_ID")
    private long id;


    private String name;
    private String color;

    public Underwear(String color, String name){
        this.color = color;
        this.name = name;
    }
}
