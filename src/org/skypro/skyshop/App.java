package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.finder.SearchEngine;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.services.Article;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        System.out.println("\nЗадачи 1 и 2");

        ProductBasket basket = new ProductBasket();

        System.out.println("\nСоздаем продукты");
        SimpleProduct apple = new SimpleProduct("Apple", 50);
        SimpleProduct lemon = new SimpleProduct("Lemon", 30);
        DiscountedProduct watermellon = new DiscountedProduct("Watermellon", 90, 20);
        DiscountedProduct corn = new DiscountedProduct("Corn", 25, 10);
        FixPriceProduct tomato = new FixPriceProduct("Tomato");

        System.out.println("\nПокупатель добавляет продукты в корзину");
        basket.addProduct(apple);
        basket.addProduct(lemon);
        basket.addProduct(watermellon);
        basket.addProduct(corn);
        basket.addProduct(tomato);

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

        System.out.println("______________________________________________________________________");

        System.out.println("\nЗадача 3");

        System.out.println("\nСоздаем описание товаров");
        Article appleInfo = new Article("Apple", "fruit and green");
        Article lemonInfo = new Article("Lemon", "fruit and yellow");
        Article watermellonInfo = new Article("Watermellon", "fruit and green");
        Article cornInfo = new Article("Corn", "vegetable and yellow");
        Article tomatoInfo = new Article("Tomato", "vegetable and red");

        System.out.println("\nСоздаем компонент поиска товаров и добавляем в него объекты Article и Product");
        SearchEngine find = new SearchEngine(10);
        find.add(apple);
        find.add(lemon);
        find.add(watermellon);
        find.add(corn);
        find.add(tomato);
        find.add(appleInfo);
        find.add(lemonInfo);
        find.add(watermellonInfo);
        find.add(cornInfo);
        find.add(tomatoInfo);

        System.out.println("\nПроизводим поиск по названию");
        System.out.println(Arrays.toString(find.search("Apple")));

        System.out.println("\nПроизводим поиск по описанию");
        System.out.println(Arrays.toString(find.search("yellow")));

        System.out.println("\nПроизводим поиск по типу");
        System.out.println(Arrays.toString(find.search("DiscountedProduct")));
    }
}