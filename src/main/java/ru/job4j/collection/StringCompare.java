package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int size = Math.min(left.length(), right.length());
        char[] charLeft = left.toCharArray();
        char[] charRight = right.toCharArray();
        for (int index = 0; index < size; index++) {
            result = Character.compare(charLeft[index], charRight[index]);
            if (result != 0) {
                break;
            }
        }
        return (result == 0) ? Integer.compare(charLeft.length, charRight.length) : result;
    }
}
