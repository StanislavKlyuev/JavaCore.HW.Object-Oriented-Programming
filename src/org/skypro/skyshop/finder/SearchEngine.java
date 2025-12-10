package org.skypro.skyshop.finder;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.*;

public class SearchEngine {

    private Map<String, Searchable> searchables;

    public SearchEngine() {
        this.searchables = new TreeMap<>();
    }

    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.computeIfAbsent(searchable.getSearchName(), key -> searchable);
        }
    }

    public List<Searchable> search(String string) {
        List<Searchable> find = new ArrayList<>();
        string = string.toLowerCase();
        for (String str : searchables.keySet()) {
            String str1 = searchables.get(str).getStringRepresentation().toLowerCase();
            String str2 = searchables.get(str).getContentType().toLowerCase();
            if (str1.contains(string) || str2.contains(string)) {
                find.add(searchables.get(str));
            }
        }
        return find;
    }

    public Searchable searchMostAppropriateElement(String search) throws BestResultNotFound {
        Searchable find = null;
        int count = 0, index;
        search = search.toLowerCase();
        for (String string : searchables.keySet()) {
            int inCount = 0;
            String str1 = searchables.get(string).getSearchName().toLowerCase();
            int subIndex = str1.indexOf(search);
            while (subIndex != -1) {
                inCount++;
                index = subIndex + search.length();
                subIndex = str1.indexOf(search, index);
            }
            if (inCount > count) {
                find = searchables.get(string);
                count = inCount;
            }
        }
        if (find == null) {
            throw new BestResultNotFound(search);
        }
        return find;
    }

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchables=" + searchables +
                '}';
    }
}