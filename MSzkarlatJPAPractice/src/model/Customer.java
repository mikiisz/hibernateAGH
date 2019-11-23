package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Customer extends Company {

    @Column(name = "Discount")
    private double discount;

    public Customer() {
        super();
    }

    public Customer(String companyName, String street, String city,
                    double discount) {
        super(companyName, street, city);
        this.discount = discount;
    }
}
