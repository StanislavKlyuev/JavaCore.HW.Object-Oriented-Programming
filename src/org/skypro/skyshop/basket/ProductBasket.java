package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductBasket {

    private Map<String, List<Product>> productBasket;

    public ProductBasket() {
        this.productBasket = new LinkedHashMap<>();
    }

    public void addProduct(Product product) {
        if (product != null) {
            productBasket.computeIfAbsent(product.getName(), key -> new ArrayList<>());
            productBasket.get(product.getName()).add(product);
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (List<Product> list : productBasket.values()) {
            for (Product product : list) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public int getSpecialProductSum() {
        int sum = 0;
        for (List<Product> list : productBasket.values()) {
            for (Product product : list) {
                if (product != null && product.isSpecial()) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public void printTotalProduct() {
        boolean isEmpty = true;
        int count = 0;
        for (List<Product> list : productBasket.values()) {
            if (list.size() != 0) {
                for (Product product : list) {
                    System.out.println(product);
                    isEmpty = false;
                    count++;
                }
            }
        }
        if (isEmpty) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Всего товаров: " + count);
            System.out.println("Общая стоимость корзины: " + getTotalPrice());
            System.out.println("Специальных товаров: " + getSpecialProductSum());
        }
    }

    public boolean findProduct(String name) {
        boolean have = false;
        for (String string : productBasket.keySet()) {
            if (name.equalsIgnoreCase(string)) {
                if (!productBasket.get(string).isEmpty()) {
                    have = true;
                    break;
                }
            }
        }
        return have;
    }

    public void clear() {
        productBasket.clear();
    }

    public List<Product> removeForName(String name) {   //Метод, предложенный наставником. Не сработает, если расхождения в регистре.
        return productBasket.remove(name);
    }


//    public List<Product> removeForName(String name) {
//        List<Product> temp = new ArrayList<>();
//        for (String string : productBasket.keySet()) {
//            if (name.equalsIgnoreCase(string)) {
//                temp = productBasket.remove(string);
//                return temp;
//            }
//        }
//        return temp;
//    }

    @Override
    public String toString() {
        return "ProductBasket{" +
                "productBasket=" + productBasket +
                '}';
    }
}