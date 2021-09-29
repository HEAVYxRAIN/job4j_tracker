package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return eng;
    }

    public static void main(String[] args) {
        DummyDic dummyDic = new DummyDic();
        String go = dummyDic.engToRus("eng");
        System.out.println("Неизвестное слово. + " + go);
    }
}
