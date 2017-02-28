package spinc.spmmvp.daggerExample.model;

/**
 * Created by webwerks on 28/2/17.
 */

public class Product {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    private String productName;
    private String description;
    private double salePrice;


    public Product(){
    }

    public Product(Product product){
        this.id = product.getId();
        this.productName = product.getProductName();
        this.description = product.getDescription();
        this.salePrice = product.getSalePrice();

    }
}
