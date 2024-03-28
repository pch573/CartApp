package assignment;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items;

    public Cart(){
        items = new HashMap<>();
    }

    public void addProduct(Product product, int quantity){
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(Product product, int quantity){
        int currentQuantity = items.getOrDefault(product, 0);
        int newQuantity = Math.max(currentQuantity - quantity, 0);
        if (newQuantity == 0) {
            items.remove(product);
        }else {
            items.put(product, newQuantity);
        }
    }

    public void showItems(){
        System.out.println("장바구니 내역:");
        for(Map.Entry<Product, Integer> entry : items.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue() + "개");
        }
    }


}
