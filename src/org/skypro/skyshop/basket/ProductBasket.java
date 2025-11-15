package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.*;

public class ProductBasket {

    private int total = 0;
    private Product[] productBasket;

    public ProductBasket() {
        this.productBasket = new Product[5];
    }

    public void addProduct(Product product) {
        for (int i = 0; i < 6; i++) {
            if (i == 5) {
                System.out.println("Невозможно добавить продукт " + product.getName() + ". Корзина заполнена.");
                break;
            }
            if (productBasket[i] == null) {
                productBasket[i] = product;
                total += product.getPrice();
                System.out.println("Добавлен продукт " + product.getName());
                break;
            }
        }
    }

    public String getTotalPrice() {
        return "Общая стоимость корзины: " + total;
    }

    public String getSpecialProductSum() {
        int sum = 0;
        for (Product product : productBasket) {
            if (product.isSpecial())
                sum++;
        }
        return "Специальных товаров: " + sum;
    }

    public void printTotalProduct() {
        boolean isEmpty = true;
        for (Product product : productBasket) {
            if (product == null)
                continue;
            System.out.println(product);
            isEmpty = false;
        }
        if (isEmpty) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println(getTotalPrice());
            System.out.println(getSpecialProductSum());
        }
    }

    public boolean findProduct(String name) {
        boolean have = false;
        for (Product product : productBasket) {
            if (product == null) {
                continue;
            }
            if (name.equalsIgnoreCase(product.getName())) {
                have = true;
                break;
            }
        }
        return have;
    }

    public void clear() {
        for (int i = 0; i < productBasket.length; i++) {
            productBasket[i] = null;
        }
        total = 0;
    }
}