package org.skypro.skyshop.finder;

import org.skypro.skyshop.interfaces.Searchable;

public class SearchEngine {

    private Searchable[] searchables;

    public SearchEngine(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Введено число меньше \"1\".");
        }
        this.searchables = new Searchable[size];
    }

    public void add(Searchable searchable) {
        boolean isAdd = false;
        while (!isAdd) {
            for (int i = 0; i < searchables.length; i++) {
                if (searchables[i] == null) {
                    searchables[i] = searchable;
                    isAdd = true;
                    break;
                }
            }
        }
    }

    public Searchable[] search(String string) {
        Searchable[] find = new Searchable[5];
        int count = 0;
        for (Searchable searchable : searchables) {
            if (searchable.getStringRepresentation().contains(string) || string.equalsIgnoreCase(searchable.getContentType())) {
                find[count] = searchable;
                count++;
            }
            if (count == 5) {
                break;
            }
        }
        return find;
    }
}