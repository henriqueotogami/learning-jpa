package model.basic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "table_product", schema = "course_java")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", length = 200, nullable = false)
    private String name;

    @Column(name = "product_price", nullable = false, precision = 11, scale = 2)
    private Double price;

    public Product() { }

    public Product(final String name, final Double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() { return id; }

    public void setId(final Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(final String name) { this.name = name; }

    public Double getPrice() { return price; }

    public void setPrice(final Double price) { this.price = price; }
}
