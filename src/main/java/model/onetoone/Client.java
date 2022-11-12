package model.onetoone;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "seat_id", unique = true)
    private Seat seat;

    public Client() { }

    public Client(final String clientName, final Seat clientSeat) {
        super();
        this.name = clientName;
        this.seat = clientSeat;
    }

    public long getId() { return id; }

    public void setId(final long clientId) { this.id = clientId; }

    public String getName() { return name; }

    public void setName(final String clientName) { this.name = clientName; }

    public Seat getSeat() { return seat; }

    public void setSeat(final Seat clientSeat) { this.seat = clientSeat; }
}