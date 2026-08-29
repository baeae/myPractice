package dto;

public class Product {

    private int productId; // 상품번호
    private String productName; // 상품명
    private int price; // 가격
    private int quantity; // 재고수량

    public Product() {}

    public Product(String name, int price, int quantity) {
        this.productName = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(int productId, String productName, int price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return String.format("%-6d %-15s %5d %5d", productId, productName, price, quantity);
    }
}
