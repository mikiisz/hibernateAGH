package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    @Column(name = "InvoiceNumber")
    private int invoiceNumber;

    @Column(name = "Quantity")
    private int quantity;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Product> includesProducts = new HashSet<>();

    public Invoice() {
    }

    public Invoice(int quantity) {
        this.quantity = 0;
    }

    public void addProduct(Product product, int quantity) {
        includesProducts.add(product);
        this.quantity += quantity;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Product> getProducts() {
        return includesProducts;
    }
}
