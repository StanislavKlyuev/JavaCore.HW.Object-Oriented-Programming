package org.skypro.skyshop.finder;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.interfaces.Searchable;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {

    private Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new TreeSet<>(new Comparator<Searchable>() {
            @Override
            public int compare(Searchable o1, Searchable o2) {
                if (o1.getSearchName().length() - o2.getSearchName().length() != 0) {
                    return o1.getSearchName().length() - o2.getSearchName().length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
    }

    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
        }
    }

    public TreeSet<Searchable> search(String string) {
        String finalString = string.toLowerCase();
        TreeSet<Searchable> find = searchables.stream()
                .filter(s -> (s.getStringRepresentation().toLowerCase().contains(finalString) || s.getContentType().toLowerCase().contains(finalString)))
                .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        return find;
    }

    public Searchable searchMostAppropriateElement(String search) throws BestResultNotFound {
        Searchable find = null;
        int count = 0, index;
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
            if (inCount > count) {
                find = searchable;
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