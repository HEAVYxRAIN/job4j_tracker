package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemDescByNameTest {

    @Test
    void compareItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("One", 1),
                new Item("Two", 2),
                new Item("Three", 3)
        );
        List<Item> expected = Arrays.asList(
                new Item("Two", 2),
                new Item("Three", 3),
                new Item("One", 1)
        );
        items.sort(new ItemAscByName().reversed());
        assertEquals(expected, items);
    }
}