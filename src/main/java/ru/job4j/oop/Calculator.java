package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int multiply(int a) {
        return x * a;
    }

    public static int minus(int m) {
        return m - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int sumAllOperation() {
        return sum(5) + multiply(5) + minus(5) + divide(5);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.sumAllOperation();
        System.out.println(result);
    }
}
