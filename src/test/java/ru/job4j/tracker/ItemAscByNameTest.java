package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemAscByNameTest {

    @Test
    void compareItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("One", 1),
                new Item("Two", 2),
                new Item("Three", 3)
        );
        List<Item> expected = Arrays.asList(
                new Item("One", 1),
                new Item("Three", 3),
                new Item("Two", 2)
        );
        items.sort(new ItemAscByName());
        assertEquals(expected, items);
    }
}