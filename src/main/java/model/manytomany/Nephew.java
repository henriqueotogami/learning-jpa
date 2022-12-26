package model.manytomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

    public String getName() { return name; }

    public void setName(final String name) { this.name = name; }

    public List<Uncle> getUnclesList() { return unclesList; }

    public void setUnclesList(final List<Uncle> unclesList) { this.unclesList = unclesList; }
}
