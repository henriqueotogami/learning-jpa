package model.onetomany;

import model.basic.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemFromOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RestaurantOrder restaurantOrder;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Double price;

    public ItemFromOrder() { }

    public ItemFromOrder(final RestaurantOrder restaurantOrder, final Product product, final int quantity){
        super();
        this.setRestaurantOrder(restaurantOrder);
        this.setProduct(product);
        this.setQuantity(quantity);
    }

    public RestaurantOrder getRestaurantOrder() { return restaurantOrder; }

    public void setRestaurantOrder(final RestaurantOrder restaurantOrder) { this.restaurantOrder = restaurantOrder; }

    public Product getProduct() { return product; }

    public void setProduct(final Product product) {
        this.product = product;
        if(product != null && this.price == null) {
            this.setPrice(product.getPrice());
        }
    }

    public int getQuantity() { return quantity; }

    public void setQuantity(final int quantity) { this.quantity = quantity; }

    public Double getPrice() { return price; }

    public void setPrice(final Double price) { this.price = price; }
}
