package model.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "people")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_code", nullable = false)
    private Long id;

    @Column(name = "person_name", nullable = false)
    private String name;

    @Transient
    private String email;

    public User() { }

    public User(final String name, final String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public Long getId() { return id; }

    public void setId(final Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(final String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(final String email) { this.email = email; }
}
