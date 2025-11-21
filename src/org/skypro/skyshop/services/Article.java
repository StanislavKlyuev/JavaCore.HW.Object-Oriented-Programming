package org.skypro.skyshop.services;

import org.skypro.skyshop.interfaces.Searchable;

public final class Article implements Searchable {

    private final String ARTICLE;
    private final String TEXT;

    public Article(String ARTICLE, String TEXT) {
        if (ARTICLE == null || ARTICLE.isBlank() || TEXT == null || TEXT.isBlank())
            throw new IllegalArgumentException("Описание продукта не действительно");
        this.ARTICLE = ARTICLE;
        this.TEXT = TEXT;
    }

    @Override
    public String toString() {
        return ARTICLE + " - " + TEXT;
    }

    @Override
    public String getSearchName() {
        return toString();
    }

    @Override
    public String getContentType() {
        return getClass().getSimpleName();
    }
}