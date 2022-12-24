package model.onetoone;

import infrastructure.DataAccessObject;
import javax.persistence.*;

@Entity
@Table(name = "seats")
public class Seat extends DataAccessObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public Seat() { }

    public Seat(final String seatName) {
        super();
        this.name = seatName;
    }

    public long getId() { return id; }

    public void setId(final long seatId) { this.id = seatId; }

    public String getName() { return name; }

    public void setName(final String seatName) { this.name = seatName; }
}