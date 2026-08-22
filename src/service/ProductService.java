package service;

import dto.Product;
import exception.ProductNotFoundException;
import java.util.List;

public interface ProductService {

    // 제품둥록
    public void registerProduct(Product product);

    // 제품조회 - 상품번호 기준 오름차순 정렬
    public List<Product> getAllProducts();

    // 제품수정 - 대상없으면 예외발생
    public void updateProduct(int productId, String productName, int price, int quantity)
            throws ProductNotFoundException;

    //제품삭제 - 대상이 없으면 예외발생
    public void deleteProduct(int productId) throws ProductNotFoundException;

}
