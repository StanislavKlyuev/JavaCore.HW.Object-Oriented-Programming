package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private int total = 0;
    private Product[] productBasket;

    public ProductBasket() {
        this.productBasket = new Product[5];
    }

    public void addProduct(String name, int price) {
        for (int i = 0; i < 6; i++) {
            if (i == 5) {
                System.out.println("Невозможно добавить продукт");
                break;
            }
            if (productBasket[i] != null)
                continue;
            productBasket[i] = new Product(name, price);
            total += price;
            break;
        }
    }

    public String getTotalPrice() {
        return "Общая стоимость корзины: " + total;
    }

    public void totalProduct() {
        boolean isEmpty = true;
        for (Product product : productBasket) {
            if (product == null)
                continue;
            System.out.println(product);
            isEmpty = false;
        }
        if (isEmpty) {
            System.out.println("в корзине пусто");
        } else
            System.out.println(getTotalPrice());
    }

    public boolean findProduct(String name) {
        boolean have = false;
        for (Product product : productBasket) {
            if (product == null)
                continue;
            if (name.equalsIgnoreCase(product.getName()))
                have = true;
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
