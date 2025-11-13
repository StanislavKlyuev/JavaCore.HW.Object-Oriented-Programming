package org.skypro.skyshop.product;

public abstract class Product {

    private String name;

    public Product(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Имя пусто");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    @Override
    public String toString() {
        return name;
    }

    public abstract boolean isSpecial();
}