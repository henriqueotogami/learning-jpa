package model.onetoone;

import infrastructure.DataAccessObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seats")
public class Seat extends DataAccessObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne(mappedBy = "seat")
    private Client client;

    public Seat() { }

    public Seat(final String seatName) {
        super();
        this.name = seatName;
    }

    public long getId() { return id; }

    public void setId(final long seatId) { this.id = seatId; }

    public String getName() { return name; }

    public void setName(final String seatName) { this.name = seatName; }


    public Client getClient() { return client; }

    public void setClient(final Client client) { this.client = client; }
}