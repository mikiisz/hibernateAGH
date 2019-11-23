package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "Products")
@Entity
public class Product {

    @Id
    @GeneratedValue
    private int productId;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "UnitsOnStock")
    private double unitsOnStock;

    // zadanie VII
    @ManyToMany(
            mappedBy = "includesProducts",
            // zadanie X
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST
    )
    private Set<Invoice> canBeSoldIn = new HashSet<>();

    // zadanie VII
    public Set<Invoice> getCanBeSoldIn() {
        return canBeSoldIn;
    }

    public String getProductName() {
        return productName;
    }

    // zadanie III
    @ManyToOne
    @JoinColumn(name = "SuppliedBy")
    private Supplier suppliedBy;

    // zadanie VI
    @ManyToOne
    private Category category;

    // zadanei VI
    public Category getCategory() {
        return category;
    }

    public Product() {

    }

    public Product(String productName, double unitsOnStock) {
        this.productName = productName;
        this.unitsOnStock = unitsOnStock;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // zadanie III
    public void setSuppliedBy(Supplier suppliedBy) {
        this.suppliedBy = suppliedBy;
        // zadanie V
        if (!suppliedBy.getProducts().contains(this)) {
            suppliedBy.addSuppliedProduct(this);
        }
    }
}
