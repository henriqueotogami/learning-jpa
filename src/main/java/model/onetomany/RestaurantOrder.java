package model.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class RestaurantOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    public RestaurantOrder() {
        this(new Date());
    }

    public RestaurantOrder(final Date dateOrder) {
        super();
        this.date = dateOrder;
    }

    public Long getId() { return id; }

    public void setId(final Long id) { this.id = id; }

    public Date getDate() { return date; }

    public void setDate(final Date date) { this.date = date; }
}
