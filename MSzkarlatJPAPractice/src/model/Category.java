package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private int CategoryId;

    @Column(name = "Name")
    private String name;

    @OneToMany
    private List<Product> products = new ArrayList<>();

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    // zadanie VI
    public void addProduct(Product product) {
        products.add(product);
        product.setCategory(this);
    }

    // zadanie IX
    public int getCategoryId() {
        return CategoryId;
    }

    public String getName() {
        return name;
    }
}
