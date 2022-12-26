package model.manytomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "actorsList")
    private List<Movie> moviesList;

    public Actor() { }

    public Actor(final String name) {
        super();
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(final String name) { this.name = name; }

    public List<Movie> getMoviesList() {
        if(moviesList == null) { moviesList = new ArrayList<>(); }
        return moviesList;
    }

    public void setMoviesList(final List<Movie> moviesList) { this.moviesList = moviesList; }
}
