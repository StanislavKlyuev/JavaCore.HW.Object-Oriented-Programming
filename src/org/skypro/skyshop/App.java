package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.finder.SearchEngine;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.services.Article;

public class App {
    public static void main(String[] args) {

        System.out.println("\nЗадачи 1 и 2. Создаем Интернет-Магазин на основе ARRAYS.");

        ProductBasket basket = new ProductBasket();

        System.out.println("\nСоздаем продукты");
        SimpleProduct lemon = new SimpleProduct("Lemon", 30);
        SimpleProduct apple = new SimpleProduct("Apple", 50);
        SimpleProduct watermellon = new SimpleProduct("Watermellon", 95);
        DiscountedProduct appleDis = new DiscountedProduct("Apple", 50, 10);
        DiscountedProduct lemonDis = new DiscountedProduct("Lemon", 30, 30);
        DiscountedProduct watermellonDis = new DiscountedProduct("Watermellon", 90, 20);
        DiscountedProduct corn = new DiscountedProduct("Corn", 25, 10);
        FixPriceProduct appleFix = new FixPriceProduct("Apple");
        FixPriceProduct tomato = new FixPriceProduct("Tomato");

        System.out.println("\nПокупатель добавляет продукты в корзину (в хаотичном порядке)");
        basket.addProduct(lemon);
        basket.addProduct(apple);
        basket.addProduct(watermellon);
        basket.addProduct(appleDis);
        basket.addProduct(lemonDis);
        basket.addProduct(watermellonDis);
        basket.addProduct(corn);
        basket.addProduct(tomato);
        basket.addProduct(appleFix);
        basket.addProduct(tomato);

        System.out.println("\nДобавление продукта в заполненную корзину, в которой нет свободного места (было актуально, когда корзина была массивом - до задачи 5)");
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

        System.out.println("\nЗадача 3. СОздаем описание товаров и поисковик. Интерфейсы.");

        System.out.println("\nСоздаем описание товаров");
        Article appleInfo = new Article("Apple", "Фрукт. Цвет - красный, жёлтый, зеленый. Круглый, сочный, сладкий. Растет в саду. На ощуп твердый, гладкий. Едят сырым, варят варенье, готовят сок.");
        Article lemonInfo = new Article("Lemon", "Фрукт из рода цитрусовых. Фрукт овальный, жёлтый, имеет приятный запах и кислый. Сверху покрыт кожурой, внутри есть дольки и семена");
        Article watermellonInfo = new Article("Watermellon", "Крупная ягода. Чаще всего круглый или овальный. Окрас белый, жёлтый, тёмно-зелёный. Едят сырым, делают сок, варят варенье.");
        Article cornInfo = new Article("Corn", "Травянистое растение. Злак. Плод — початок, спрятанный под зелёными листьями-обёртками. На початке рядами растут жёлтые, белые или даже разноцветные зёрна.");
        Article tomatoInfo = new Article("Tomato", "Овощ. Красный и круглый. На вкус кисло-сладкий. Растёт в огороде на грядке. На ощупь мягкий, гладкий. Можно приготовить салат, суп, сок, кетчуп.");

        System.out.println("\nСоздаем компонент поиска товаров и добавляем в него объекты Article и Product в хаотичном порядке");
        SearchEngine find = new SearchEngine();   // до задачи №5 здесь передавался аргумент - размер корзины (количество элементов массива)
        find.add(lemonInfo);
        find.add(lemon);
        find.add(watermellon);
        find.add(corn);
        find.add(watermellonInfo);
        find.add(cornInfo);
        find.add(tomatoInfo);
        find.add(apple);
        find.add(lemonDis);
        find.add(watermellonDis);
        find.add(appleDis);
        find.add(appleFix);
        find.add(tomato);
        find.add(tomato);
        find.add(appleInfo);

        System.out.println("\nПроизводим поиск по названию");
        System.out.println(find.search("Apple"));

        System.out.println("\nПроизводим поиск по описанию");
        System.out.println(find.search("фрукт"));

        System.out.println("\nПроизводим поиск по типу");
        System.out.println(find.search("SimpleProduct"));

        System.out.println("______________________________________________________________________");

        System.out.println("\nЗадача 4. Перехват ошибок. ИСКЛЮЧЕНИЯ.");

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

        System.out.println("______________________________________________________________________");

        System.out.println("\nЗадача 5. Изменяем струтуру магазина с ARRAYS на LIST");

        System.out.println("\nДля проверки добавим наши продукты в корзину");
        basket.addProduct(apple);
        basket.addProduct(appleDis);
        basket.addProduct(appleFix);
        basket.addProduct(lemon);
        basket.addProduct(lemonDis);
        basket.addProduct(watermellon);
        basket.addProduct(watermellonDis);
        basket.addProduct(corn);
        basket.addProduct(tomato);
        basket.addProduct(tomato);
        basket.addProduct(whiskey);

        System.out.println("\nУдаляем продукт из корзины по имени и выводим его на экран");
        System.out.println(basket.removeForName("lemon"));

        System.out.println("\nПроверяем продукты в корзине после удаления");
        basket.printTotalProduct();

        System.out.println("\nПытаемся удалить продукт, которого нет в корзине");
        System.out.println(basket.removeForName("potato"));

        System.out.println("\nПроверяем продукты в корзине после удаления несуществующего продукта");
        basket.printTotalProduct();

        System.out.println("______________________________________________________________________");

        System.out.println("\nЗадача 6. Изменяем струтуру магазина с LIST на MAP");

        System.out.println("______________________________________________________________________");

        System.out.println("\nЗадача 7. Изменяем поисковик с Мар на Set. Сортировка (Comarable / Comparator)");

        System.out.println("find = " + find);

        System.out.println("______________________________________________________________________");



    }
}