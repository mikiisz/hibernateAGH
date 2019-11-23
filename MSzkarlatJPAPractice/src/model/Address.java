package model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String city;

    public Address() {
    }

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

}