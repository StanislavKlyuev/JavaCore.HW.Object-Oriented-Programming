package org.skypro.skyshop.finder;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> search(String string) {
        List<Searchable> find = new ArrayList<>();
        string = string.toLowerCase();
        for (Searchable searchable : searchables) {
            String str1 = searchable.getStringRepresentation().toLowerCase();
            String str2 = searchable.getContentType().toLowerCase();
            if (str1.contains(string) || str2.contains(string)) {
                find.add(searchable);
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