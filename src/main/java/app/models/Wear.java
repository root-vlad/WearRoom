package app.models;



import javax.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@MappedSuperclass
public class Wear {
    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected long id;

    private String name;
    private String color;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserWear user;

    public Wear() { }

    public Wear(String color, String name){
        this.color = color;
        this.name = name;
    }

    public Wear(String color, String name, UserWear user){
        this.color = color;
        this.name = name;
        this.user = user;
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
