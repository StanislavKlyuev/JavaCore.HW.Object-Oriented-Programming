package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена товара не соответствует");
        }
        this.price = price;;
        System.out.println("Создан продукт " + name);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}