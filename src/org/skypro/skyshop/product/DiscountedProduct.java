package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int basePrice;
    private int discountPercent;

    public DiscountedProduct(String name, int basePrice, int discountPercent) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цена продукта \"" + name + "\" не корректна");
        }
        this.basePrice = basePrice;
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Скидка на продукт \"" + name + "\" не действительна");
        }
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