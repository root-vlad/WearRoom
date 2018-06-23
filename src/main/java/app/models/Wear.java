package app.models;



import javax.persistence.*;

@MappedSuperclass
public class Wear {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)

    protected long id;

    private String name;
    private String color;

    public Wear() { }

    public Wear(String color, String name){
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public long getId() {
        return id;
    }
}
