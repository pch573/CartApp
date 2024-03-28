package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CartApp {
    // CSV 파일로부터 상품 목록을 읽어오는 메소드
    public static Set<Product> loadProductsFromCSV(String filePath){
        Set<Product> products = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                int key =Integer.parseInt(values[0]);
                String name = values[1];
                double price = Double.parseDouble(values[2]);
                products.add(new Product(key, name, price));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public static void main(String[] args) {

//        CSV 파일로부터 상품 목록불러오기
//        Set<Product> productSet = loadProductsFromCSV("");

//        상품 목록 생성
        Set<Product> productSet = new HashSet<>();
//        TODO: 상품 클래스를 생성하여 상품 목록에 넣는다.

        productSet.add(new Product(1, "우유", 2.50));
        productSet.add(new Product(2,"사과", 0.75));
        productSet.add(new Product(3, "화장지", 4.9));
//        중복 상품 추가 시도(추가 x)
        productSet.add(new Product(1, "우유", 2.50));

//        상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet){
            System.out.println(product.getName() + " : " + product.getPrice());
        }

//        장바구니 생성
        Cart myCart = new Cart();

//         상품을 장바구니에 추가
        myCart.addProduct(new Product(1, "우유", 2.50), 2); // 우유 2개
        myCart.addProduct(new Product(2, "사과", 0.75), 1); // 사과 1개

//        장바구니에 현재 담긴 상품들을 출력(상품이름, 각 상품의 개수)
        myCart.showItems();
//        상품을 장바구니에서 제거
        myCart.removeProduct(new Product(1, "우유", 2.50), 1); //우유 1개 제거
//        변경된 장바구니 내역 출력
        myCart.showItems();


    }

}
