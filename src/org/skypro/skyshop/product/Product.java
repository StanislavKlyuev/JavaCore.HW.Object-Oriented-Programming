package org.skypro.skyshop.product;

import org.skypro.skyshop.interfaces.Searchable;

public abstract class Product implements Searchable {

    private String name;

    public Product(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Имя продукта не корректно");
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

    @Override
    public String getSearchName() {
        return name;
    }

    @Override
    public String getContentType() {
        return getClass().getSimpleName();
    }
}