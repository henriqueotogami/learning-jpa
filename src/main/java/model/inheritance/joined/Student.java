package model.inheritance.joined;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("AL") // AL = Aluno
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
