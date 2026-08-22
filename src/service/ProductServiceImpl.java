package service;

import dto.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final List<Product> productList = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void registerProduct(Product product) {
        product.setProductId(nextId++);
        productList.add(product);

    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> sorted = new ArrayList<>(productList);
        sorted.sort((p1, p2) -> p1.getProductId() - p2.getProductId());
        return sorted;
    }

    @Override
    public void updateProduct(int productId, String productName, int price, int quantity) {

    }

    @Override
    public void deleteProduct(int productId) {

    }
}
