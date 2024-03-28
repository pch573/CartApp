package assignment;

import java.util.HashSet;
import java.util.Set;

import static assignment.ProductUtils.loadProductsFromCSV;

public class CartApp {
    // CSV 파일로부터 상품 목록을 읽어오는 메소드

    public static void main(String[] args) {

//        상품 목록 생성
//        Set<Product> productSet = new HashSet<>();

        //        CSV 파일로부터 상품 목록불러오기
        String filePath = "C:\\Users\\cksgh\\Downloads\\products.csv";
        Set<Product>productSet = loadProductsFromCSV(filePath);
//
//        productSet.add(new Product(1, "우유", 2.50));
//        productSet.add(new Product(2,"사과", 0.75));
//        productSet.add(new Product(3, "화장지", 4.9));
////        중복 상품 추가 시도(추가 x)
//        productSet.add(new Product(1, "우유", 2.50));


//        상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet){
            System.out.println(product.getName() + " : " + product.getPrice());
        }

//        상품 목록을 CSV 파일로 내보내기
//        String filePath = "C:\\Users\\cksgh\\Downloads\\products.csv";
//        ProductUtils.exportProductsToCSV(productSet, filePath);
//        System.out.println("상품 목록이 '" +filePath+"' 파일로 내보내졌습니다.");

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
