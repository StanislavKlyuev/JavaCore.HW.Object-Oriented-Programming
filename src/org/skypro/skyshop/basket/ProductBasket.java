package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.*;

public class ProductBasket {

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
                System.out.println("Добавлен продукт " + product.getName());
                break;
            }
        }
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
        for (int i = 0; i < productBasket.length; i++) {
            productBasket[i] = null;
        }
    }
}