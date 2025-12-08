package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.*;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {

    private List<Product> productBasket;

    public ProductBasket() {
        this.productBasket = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productBasket.add(product);
    }

    public List<Product> removeForName(String name) {
        List<Product> temp = new ArrayList<>();
        temp.addAll(productBasket);
        temp.removeIf(product -> !product.getName().equalsIgnoreCase(name));
        productBasket.removeIf(product -> product.getName().equalsIgnoreCase(name));
        return temp;
    }

    public int getTotalPrice() {
        int total = 0;
        for (Product product : productBasket) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public int getSpecialProductSum() {
        int sum = 0;
        for (Product product : productBasket) {
            if (product != null && product.isSpecial())
                sum++;
        }
        return sum;
    }

    public void printTotalProduct() {
        boolean isEmpty = true;
        for (Product product : productBasket) {
            if (product != null) {
                System.out.println(product);
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Общая стоимость корзины: " + getTotalPrice());
            System.out.println("Специальных товаров: " + getSpecialProductSum());
        }
    }

    public boolean findProduct(String name) {
        boolean have = false;
        for (Product product : productBasket) {
            if (product != null && name.equalsIgnoreCase(product.getName())) {
                have = true;
                break;
            }
        }
        return have;
    }

    public void clear() {
        productBasket.clear();
    }
}