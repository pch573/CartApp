package assignment;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ProductUtils {
//    CSV 파일로부터 상품 목록을 읽어오는 메소드
    public static Set<Product> loadProductsFromCSV(String filePath){
        Set<Product> products = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))){
            br.readLine(); // 첫 줄 건너뛰기 CSV 파일의 헤더를 무시하기
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

    public static void exportProductsToCSV(Set<Product> products, String filePath){
//        상품목록을 CSV 파일로 내보내는 메소드
        try(PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath),"UTF-8"))) {
//            CSV 파일의 헤더 작성
            pw.println("Key,Name,Price");
//            각 상품 정보를 CSV 형식으로 파일에 작성
            for(Product product : products){
                pw.println(product.getKey() + "," +product.getName() +"," + product.getPrice());
            }
        } catch (IOException e) {
            System.out.println("파일 쓰기 오류: " + e.getMessage());
        }
    }
}
