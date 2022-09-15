package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] taskLeft = left.split(". ");
        String[] taskRight = right.split(". ");
        int leftLeft = Integer.parseInt(taskLeft[0]);
        int rightRight = Integer.parseInt(taskRight[0]);
        return Integer.compare(leftLeft, rightRight);
    }
}
