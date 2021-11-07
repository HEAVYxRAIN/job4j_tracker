package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void maxWhen2numbers() {
        int expected = 3;
        int first = 2;
        int second = 3;
        int out = new Max().max(first, second);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void maxWhen3numbers() {
        int expected = 5;
        int first = 2;
        int second = 3;
        int third = 5;
        int out = new Max().max(first, second, third);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void maxWhen4numbers() {
        int expected = 9;
        int first = 2;
        int second = 3;
        int third = 5;
        int four = 9;
        int out = new Max().max(first, second, third, four);
        Assert.assertEquals(expected, out);
    }
}