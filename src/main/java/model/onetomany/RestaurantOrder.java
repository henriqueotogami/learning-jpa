package model.onetomany;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class RestaurantOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @OneToMany(mappedBy = "restaurantOrder")
    private List<ItemFromOrder> itemsFromOrder;

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

    public List<ItemFromOrder> getItemsFromOrder() { return itemsFromOrder; }

    public void setItemsFromOrder(final List<ItemFromOrder> itemsFromOrder) { this.itemsFromOrder = itemsFromOrder; }
}
