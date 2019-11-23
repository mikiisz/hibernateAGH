package model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Company {

    @Id
    @GeneratedValue
    private int companyId;

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "Street")
    private String street;

    @Column(name = "City")
    private String city;

    public Company() {
    }

    public Company(String companyName, String street, String city) {
        this.companyName = companyName;
        this.street = street;
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }
}