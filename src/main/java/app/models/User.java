package app.models;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected long id;

    private String name;
    private String color;

    public User() { }

    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }
}