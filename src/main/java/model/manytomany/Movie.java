package model.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies" )
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double rating;

    @ManyToMany
    @JoinTable(
            name = "actors_movies",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id")
    )
    private List<Actor> actorsList;


    public Movie() { }

    public Movie(final String name, final Double rating) {
        super();
        this.name = name;
        this.rating = rating;
    }

    public String getName() { return name; }

    public void setName(final String name) { this.name = name; }

    public Double getRating() { return rating; }

    public void setRating(final Double rating) { this.rating = rating; }

    public List<Actor> getActorsList() {
        if(actorsList == null) { actorsList = new ArrayList<>(); }
        return actorsList;
    }

    public void setActorsList(final List<Actor> actorsList) { this.actorsList = actorsList; }

    public void addActorToMovie(final Actor actor){
        if (actor != null && (getActorsList().contains(actor) == false)) {
            getActorsList().add(actor);
            if(actor.getMoviesList().contains(this) == false) {
                actor.getMoviesList().add(this);
            }
        }

    }
}
