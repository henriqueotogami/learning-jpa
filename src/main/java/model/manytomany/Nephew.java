package model.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Nephew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "nephewsList")
    private List<Uncle> unclesList = new ArrayList<>();

    public Nephew() { }

    public Nephew(final String name) {
        super();
        this.name = name;
    }

    public Long getId() { return id; }

    public void setId(final Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(final String name) { this.name = name; }

    public List<Uncle> getUnclesList() { return unclesList; }

    public void setUnclesList(final List<Uncle> unclesList) { this.unclesList = unclesList; }
}
