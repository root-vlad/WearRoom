package app.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserWear {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected long id;

    private String name;

    public UserWear() { }

    public UserWear(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }


    @OneToMany(mappedBy="user",cascade={CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Wear> wears = new ArrayList<Wear>();     // c номером и порядком!

    public List<Wear> getWears() {
        return wears;
    }

    public void setWears(List<Wear> wears) {
        this.wears = wears;
    }

    public void addWears(Wear wear){
        this.wears.add(wear);
    }



}