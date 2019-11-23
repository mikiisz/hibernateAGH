package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "Suppliers")
@Entity
public class Supplier extends Company {

    @Column(name = "BankAccountNumber")
    public String bankAccountNumber;

    // zadanie XI
    // replace with Address
//    @Column(name = "street")
//    private String street;

    // replace with Address
//    @Column(name = "city")
//    private String city;

    // zastapione zadaniem XII
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "street", column = @Column(name = "Street")),
//            @AttributeOverride(name = "city", column = @Column(name = "City"))
//    })
//    private Address address;

    // zadanie IV
    @OneToMany
    // z tabelą łącznikową
//    @JoinTable(
//            name = "SuppliedBy",
//            joinColumns = {@JoinColumn(name = "Supplier_Id")},
//            inverseJoinColumns = {@JoinColumn(name = "Product_ID")}
//    )
    @JoinTable(name = "SuppliedBy")
    private Set<Product> products = new HashSet<>();

    public Supplier() {

    }

    public Supplier(String companyName, String street, String city) {
//    public Supplier(String companyName, Address address) {
        super(companyName, street, city);

        //replaced with Address
//        this.street = street;
//        this.city = city;
    }

    // zadanie IV
    public void addSuppliedProduct(Product product) {
        products.add(product);
        product.setSuppliedBy(this);
    }

    // zadanie V
    public Set<Product> getProducts() {
        return products;
    }
}
