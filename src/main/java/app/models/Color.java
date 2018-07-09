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

    private String colorName;

    public Color() {}
    public Color(String colorName) {
        this.colorName = colorName;

    }

    public String getColor() {
        return colorName;
    }


}
