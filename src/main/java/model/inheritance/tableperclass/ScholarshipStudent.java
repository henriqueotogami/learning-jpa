package model.inheritance.tableperclass;

import javax.persistence.Entity;

@Entity
public class ScholarshipStudent extends Student{

    private double scholarshipCost;

    public ScholarshipStudent() { }

    public ScholarshipStudent(final Long registrationNumber, final String name, final double scholarshipCost) {
        super(registrationNumber, name);
        this.scholarshipCost = scholarshipCost;
    }

    public double getScholarshipCost() { return scholarshipCost; }
}
