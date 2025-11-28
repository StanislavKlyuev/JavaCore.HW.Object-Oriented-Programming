package org.skypro.skyshop.interfaces;

public interface Searchable {

    default String getStringRepresentation() {
        return getSearchName() + " - " + getClass().getSimpleName();
    }

    String getContentType();

    String getSearchName();
}