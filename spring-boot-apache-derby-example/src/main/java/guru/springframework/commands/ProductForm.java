package guru.springframework.commands;


/**
 * Created by jt on 1/10/17.
 */
public class ProductForm {
    private Long id;
    private String productName;
    private String unitsOnStock;
    private String category;

    public ProductForm() {

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

    public void setCategory(String category) {
        this.category = category;
    }
}
