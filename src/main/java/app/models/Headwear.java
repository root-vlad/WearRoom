package app.models;

import javax.persistence.*;

@Entity
@Table
public class Headwear {

    @Id
    @GeneratedValue
    @Column(name="HEADWEAR_ID")
    private long id;


    private String name;
    private String color;

    public Headwear(String color, String name){
        this.color = color;
        this.name = name;
    }
}
