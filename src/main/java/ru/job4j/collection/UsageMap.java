package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> users = new HashMap<>();
        users.put("heavyxrain@yandex.ru", "Porechnev Vyacheslav Alekseevych");
        users.put("pupzab@yandex.ru", "Pupkin Zabit Magomedsharypovich");
        users.put("johnbidon69@marazm.ru", "John Biden Jr");
        for (String key : users.keySet()) {
            System.out.println(key + " = " + users.get(key));
        }
    }
}
