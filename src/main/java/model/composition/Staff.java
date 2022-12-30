package model.composition;

import javax.persistence.*;

@Entity
@Table(name = "staffs")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Address address;

    public Staff() { }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(final String name) { this.name = name; }

    public Address getAddress() { return address; }

    public void setAddress(final Address address) { this.address = address; }
}
