package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
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
        Article appleInfo = new Article("Apple", "Фрукт. Цвет - красный, жёлтый, зеленый. Круглый, сочный, сладкий. Растет в саду. На ощуп твердый, гладкий. Едят сырым, варят варенье, готовят сок.");
        Article lemonInfo = new Article("Lemon", "Фрукт из рода цитрусовых. Фрукт овальный, жёлтый, имеет приятный запах и кислый. Сверху покрыт кожурой, внутри есть дольки и семена");
        Article watermellonInfo = new Article("Watermellon", "Крупная ягода. Чаще всего круглый или овальный. Окрас белый, жёлтый, тёмно-зелёный. Едят сырым, делают сок, варят варенье.");
        Article cornInfo = new Article("Corn", "Травянистое растение. Злак. Плод — початок, спрятанный под зелёными листьями-обёртками. На початке рядами растут жёлтые, белые или даже разноцветные зёрна.");
        Article tomatoInfo = new Article("Tomato", "Овощ. Красный и круглый. На вкус кисло-сладкий. Растёт в огороде на грядке. На ощупь мягкий, гладкий. Можно приготовить салат, суп, сок, кетчуп.");

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
        System.out.println(Arrays.toString(find.search("фрукт")));

        System.out.println("\nПроизводим поиск по типу");
        System.out.println(Arrays.toString(find.search("DiscountedProduct")));

        System.out.println("______________________________________________________________________");

        System.out.println("\nЗадача 4");

        System.out.println("\nСоздаем продукты с ошибками");
        try {
            SimpleProduct lime = new SimpleProduct("Lime", -30);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            DiscountedProduct greupfruit = new DiscountedProduct("Greupfruit", 40, 120);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            FixPriceProduct strawberry = new FixPriceProduct("     ");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println("\nИщем максимальное количество повторений");
        try {
            System.out.println(find.searchMostAppropriateElement("фрукт"));
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }

        System.out.println("\nИщем по отсутствующему слову");
        try {
            System.out.println(find.searchMostAppropriateElement("корабль"));
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }
    }
}