package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.*;

import java.util.*;

public class ProductBasket {

    private Map<String, List<Product>> productBasket;

    public ProductBasket() {
        this.productBasket = new LinkedHashMap<>();
    }

    public void addProduct(Product product) {
        if (product != null) {
            productBasket.computeIfAbsent(product.getName(), key -> new ArrayList<>());
            productBasket.get(product.getName()).add(product);
        }
    }

    public int getTotalPrice() {
        return productBasket.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(p -> p.getPrice())
                .sum();
    }

    public int getSpecialProductSum() {
        return (int) productBasket.values().stream()
                .flatMap(Collection::stream)
                .filter(product -> product.isSpecial())
                .count();
    }

    public int getTotalProduct() {
        return (int) productBasket.values().stream()
                .flatMap(Collection::stream)
                .count();
    }

    public void printTotalProduct() {
        productBasket.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
        if (getTotalPrice() == 0) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Всего товаров: " + getTotalProduct());
            System.out.println("Общая стоимость корзины: " + getTotalPrice());
            System.out.println("Специальных товаров: " + getSpecialProductSum());
        }
    }

    public boolean findProduct(String name) {
        boolean have = false;
        for (String string : productBasket.keySet()) {
            if (name.equalsIgnoreCase(string)) {
                if (!productBasket.get(string).isEmpty()) {
                    have = true;
                    break;
                }
            }
        }
        return have;
    }

    public void clear() {
        productBasket.clear();
    }

    public List<Product> removeForName(String name) {
        List<Product> temp = new ArrayList<>();
        for (String string : productBasket.keySet()) {
            if (name.equalsIgnoreCase(string)) {
                temp = productBasket.remove(string);
                return temp;
            }
        }
        return temp;
    }

    @Override
    public String toString() {
        return "ProductBasket{" +
                "productBasket=" + productBasket +
                '}';
    }
}