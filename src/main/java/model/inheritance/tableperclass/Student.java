package model.inheritance.tableperclass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Student {

    @Id
    private Long registrationNumber;

    private String name;

    public Student() { }

    public Student(Long registrationNumber, String name) {
        super();
        this.registrationNumber = registrationNumber;
        this.name = name;
    }

    public Long getRegistrationNumber() { return registrationNumber; }

    public String getName() { return name; }
}
