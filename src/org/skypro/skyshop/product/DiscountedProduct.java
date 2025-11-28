package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int basePrice;
    private int discountPercent;

    public DiscountedProduct(String name, int basePrice, int discountPercent) {
        super(name);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
        System.out.println("Создан продукт со скидкой " + name);
    }

    @Override
    public int getPrice() {
        return basePrice - basePrice * discountPercent / 100;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + getPrice() + " (" + discountPercent + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}