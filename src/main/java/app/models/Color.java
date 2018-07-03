package app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected long id;

    private String color;

    public Color() {}

    public String getColor1() {
        return color;
    }

    public Color(String color) {
        this.color = color;

    }
}
