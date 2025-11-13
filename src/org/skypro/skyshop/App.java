package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        System.out.println("Покупатель добавляет продукты в корзину");
        basket.addProduct("Apple", 50);
        basket.addProduct("Watermellon", 90);
        basket.addProduct("Lemon", 30);
        basket.addProduct("Potato", 25);
        basket.addProduct("Bread", 45);
        /*
        Есть два варианта пополнения корзины:
          1. Сначала создать продукт, затем добавить его в корзину (2 строчки кода)
          2. Определять продукт при добавлении в корзину (1 строчка кода).
        Здесь представлен второй вариант
        */

        System.out.println("\nДобавление продукта в заполненную корзину, в которой нет свободного места");
        basket.addProduct("Whiskey", 1000);

        System.out.println("\nПечать содержимого корзины с несколькими товарами");
        basket.totalProduct();

        System.out.println("\nПолучение стоимости корзины с несколькими товарами");
        System.out.println(basket.getTotalPrice());

        System.out.println("\nПоиск товара, который есть в корзине");
        System.out.println(basket.findProduct("lemon"));

        System.out.println("\nПоиск товара, которого нет в корзине");
        System.out.println(basket.findProduct("banana"));

        System.out.println("\nОчистка корзины");
        basket.clear();

        System.out.println("\nПечать содержимого пустой корзины");
        basket.totalProduct();

        System.out.println("\nПолучение стоимости пустой корзины");
        System.out.println(basket.getTotalPrice());

        System.out.println("\nПоиск товара по имени в пустой корзине");
        System.out.println(basket.findProduct("Whiskey"));


    }
}
