package org.skypro.skyshop.finder;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.interfaces.Searchable;
import org.skypro.skyshop.product.Product;

import java.util.Locale;

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
        string = string.toLowerCase();
        for (Searchable searchable : searchables) {
            String str1 = searchable.getStringRepresentation().toLowerCase();
            String str2 = searchable.getContentType().toLowerCase();
            if (str1.contains(string) || str2.contains(string)) {
                find[count] = searchable;
                count++;
            }
            if (count == 5) {
                break;
            }
        }
        return find;
    }

    public Searchable searchMostAppropriateElement(String search) throws BestResultNotFound {
        Searchable find = null;
        int count = 0, index = 0;
        search = search.toLowerCase();
        for (Searchable searchable : searchables) {
            int inCount = 0;
            String str1 = searchable.getSearchName().toLowerCase();
            int subIndex = str1.indexOf(search);
            while (subIndex != -1) {
                inCount++;
                index = subIndex + search.length();
                subIndex = str1.indexOf(search, index);
            }
            find = inCount > count ? searchable : find;
            count = inCount;
        }
        if (find == null) {
            throw new BestResultNotFound(search);
        }
        return find;
    }
}