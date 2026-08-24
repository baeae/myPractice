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
        }



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




    private static int readInt(String message) {
        while (true) {
            System.out.println(message);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                return value;
            }else{
                System.out.println("[오류] 숫자만입력해주세요.");
                sc.next();
            }
        }
    }

}//class 종료
