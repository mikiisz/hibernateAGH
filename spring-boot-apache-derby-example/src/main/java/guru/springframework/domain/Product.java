package guru.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * Created by jt on 1/10/17.
 */
@Entity
public class Product {

    @javax.persistence.Id
    @GeneratedValue
    private Long id;
    private String productName;
    private String unitsOnStock;
    private String category;

    public Product(String productName, String unitsOnStock) {
        this.productName = productName;
        this.unitsOnStock = unitsOnStock;
    }

    public Product() {

    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getUnitsOnStock() {
        return unitsOnStock;
    }

    public String getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setUnitsOnStock(String unitsOnStock) {
        this.unitsOnStock = unitsOnStock;
    }
}
