package service;

import dto.Product;

import java.util.List;

public interface ProductService {

    public void registerProduct(Product product);

    public List<Product> getAllProducts();

    public void updateProduct(int productId, String productName, int price, int quantity);

    public void deleteProduct(int productId);

}
