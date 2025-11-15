package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        System.out.println("\nСоздаем продукты");
        SimpleProduct apple = new SimpleProduct("Apple", 50);
        SimpleProduct lemon = new SimpleProduct("Lemon", 30);
        DiscountedProduct watermellon = new DiscountedProduct("Watermellon", 90, 20);
        DiscountedProduct potato = new DiscountedProduct("Potato", 25, 10);
        FixPriceProduct bread = new FixPriceProduct("Bread");

        System.out.println("\nПокупатель добавляет продукты в корзину");
        basket.addProduct(apple);
        basket.addProduct(lemon);
        basket.addProduct(watermellon);
        basket.addProduct(potato);
        basket.addProduct(bread);

        System.out.println("\nДобавление продукта в заполненную корзину, в которой нет свободного места");
        SimpleProduct whiskey = new SimpleProduct("Whiskey", 1000);
        basket.addProduct(whiskey);

        System.out.println("\nПечать содержимого корзины с несколькими товарами");
        basket.printTotalProduct();

        System.out.println("\nПолучение стоимости корзины с несколькими товарами");
        System.out.println(basket.getTotalPrice());

        System.out.println("\nПоиск товара, который есть в корзине");
        System.out.println(basket.findProduct("lemon"));

        System.out.println("\nПоиск товара, которого нет в корзине");
        System.out.println(basket.findProduct("banana"));

        System.out.println("\nОчистка корзины");
        basket.clear();

        System.out.println("\nПечать содержимого пустой корзины");
        basket.printTotalProduct();

        System.out.println("\nПолучение стоимости пустой корзины");
        System.out.println(basket.getTotalPrice());

        System.out.println("\nПоиск товара по имени в пустой корзине");
        System.out.println(basket.findProduct("Whiskey"));
    }
}