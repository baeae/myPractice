package dto;

public class Product {

    private int productID;
    private String productName;
    private int Price;
    private int quantity;

    public Product() {
    }

    public Product(int productID, String productName, int price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.Price = price;
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        this.Price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("productID=").append(productID);
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", Price=").append(Price);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}
