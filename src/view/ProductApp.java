package view;

import dto.Product;
import exception.ProductNotFoundException;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ProductApp {
    private static final Scanner sc = new Scanner(System.in);
    private static final ProductService productService = new ProductServiceImpl();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int menu = readInt("메뉴를 선택하세요 >> ");

            switch (menu){
                case 1 -> registerProduct();
                case 2 -> printAllproducts();
                case 3 -> updateProduct();
                case 4 -> deleteProduct();
                case 5 ->{
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                }
                default -> System.out.println("[오류] 1~5 사이의 숫자를 입력하세요.\n");
            }
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("==============================");
        System.out.println("        상 품 관 리 시 스 템      ");
        System.out.println("==============================");
        System.out.println("1. 제품 등록");
        System.out.println("2. 제품 현황");
        System.out.println("3. 상품 수정");
        System.out.println("4. 상품 삭제");
        System.out.println("5. 종료");
        System.out.println("==============================");
    }

    //1) 제품등록
    private static void registerProduct(){
        System.out.println("\n---제품등록---");
        System.out.println("상품명 : ");
        String name = sc.next();
        int price = readInt("가격 : ");
        int quantity = readInt("수량 : ");

        Product product = new Product(name, price, quantity);
        productService.registerProduct(product);

        System.out.println("[등록완료] 상품번호 " + product.getProductId() + "번으로 등록되었습니다.\n");
    }

    //2)제품현황
    private static void printAllproducts(){
        System.out.println("\n---제품현황---");
        List<Product> products = productService.getAllProducts();

        if(products.isEmpty()){
            System.out.println("등록된 상품이 없습니다.\n");
            return;
        }

        System.out.printf("%-6s %-15s %-10s %-8s%n", "번호", "상품명", "가격", "수량");

        System.out.println("----------------------------------------------------");
        for (Product product : products){
            System.out.println(product);
        }
        System.out.println();
    }

    // 3) 제품수정
    private static void updateProduct(){
        System.out.println("\n---제품수정---");
        int id = readInt("수정할 상품번호 : ");
        System.out.println("새 상품명 : ");
        String name = sc.next();
        int price = readInt("새 가격 : ");
        int quantity = readInt("새 수량 : ");

        try{
            productService.updateProduct(id, name, price, quantity);
            System.out.println("[수정완료] 상품번호 " + id + "번이 수정되었습니다.\n");
        }catch (ProductNotFoundException e){
            System.out.println("[오류] " + e.getMessage() + "\n");
        }
    }

    // 4) 제품삭제
    private static void deleteProduct(){
        System.out.println("\n---제품삭제---");
        int id = readInt("삭제할 상품번호 : ");

        try{
            productService.deleteProduct(id);
            System.out.println("[삭제완료] 상품번호 " + id + "번이 삭제 되었습니다.\n");
        }catch (ProductNotFoundException e){
            System.out.println("[오류] " + e.getMessage() + "\n");
        }
    }




    private static int readInt(String message) {
        while (true) {
            System.out.println(message);
            if (sc.hasNextInt()) {

                return sc.nextInt();
            }else{
                System.out.println("[오류] 숫자만입력해주세요.");
                sc.next();
            }
        }
    }

}//class 종료
