package org.skypro.skyshop.product;

public class Product {

    private String name;
    private int price;

    public Product(String name, int price) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Имя пусто");
        this.name = name;
        if (price <= 0)
            throw new IllegalArgumentException("Цена товара не соответствует");
        this.price = price;
        System.out.println("Продукт добавлен");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + price;
    }
}
