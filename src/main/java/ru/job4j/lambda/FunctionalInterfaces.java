package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = (k, v) -> map.put(k, v);
        biConsumer.accept(1, "one");
        biConsumer.accept(2, "two");
        biConsumer.accept(3, "three");
        biConsumer.accept(4, "four");
        biConsumer.accept(5, "five");
        biConsumer.accept(6, "six");
        biConsumer.accept(7, "seven");

        BiPredicate<Integer, String> biPredicate = (k, v) -> k % 2 == 0 || v.length() == 4;
        for (Integer i : map.keySet()) {
            if (biPredicate.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }
        Supplier<ArrayList<String>> supplier = () -> new ArrayList<>(map.values());
        ArrayList<String> strings = supplier.get();
        Consumer<String> consumer = (s) -> System.out.println(s);
        Function<String, String> function = s -> s.toUpperCase();
        for (String s : strings) {
            consumer.accept(function.apply(s));
        }
    }
}