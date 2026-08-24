package service;

import dto.Product;
import exception.ProductNotFoundException;

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
    public void updateProduct(int productId, String productName, int price, int quantity) throws ProductNotFoundException {

            Product target = findById(productId);

            target.setProductName(productName);
            target.setPrice(price);
            target.setQuantity(quantity);


    }

    @Override
    public void deleteProduct(int productId) throws ProductNotFoundException {
        Product target = findById(productId);
        productList.remove(target);

    }

    private Product findById(int productId) throws ProductNotFoundException{
        for(Product product : productList){
            if (product.getProductId() == productId){
                return product;
            }
        }
        throw new ProductNotFoundException("상품번호 " + productId + "번을 찾을 수 없습니다.");
    }

}
