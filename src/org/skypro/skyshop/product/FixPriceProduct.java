package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final int FIX_PRICE = 55;

    public FixPriceProduct(String name) {
        super(name);
        System.out.println("Создан продукт с фиксированной ценой " + name);
    }

    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return super.toString() + ": Фиксированная цена " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}