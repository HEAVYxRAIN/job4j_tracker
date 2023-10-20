package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> departments) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : departments) {
            String start = "";
            for (String el : value.split("/")) {
                start += (start.isEmpty() ? "" : "/") + el;
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> list) {
        list.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> list) {
        list.sort(new DepDescComp());
    }
}
