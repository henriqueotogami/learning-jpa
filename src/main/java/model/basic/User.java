package model.basic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Long id;

    private String name;

    private String email;

    public User() { }

    public User(final String name, final String email) {
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
