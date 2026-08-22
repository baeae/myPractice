package service;

import dto.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    int nextId;

    private Product findById(int productId) {
        return null;
    }


    @Override
    public void registerProduct(Product product) {

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public void updateProduct(int productId, String productName, int price, int quantity) {

    }

    @Override
    public void deleteProduct(int productId) {

    }
}
