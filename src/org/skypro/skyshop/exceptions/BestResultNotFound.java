package org.skypro.skyshop.exceptions;

public class BestResultNotFound extends Exception {

    private String search;

    public BestResultNotFound(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "BestResultNotFound {" +
                "Статья по ключевому слову \"" + search + "\" не найдена}";
    }
}
