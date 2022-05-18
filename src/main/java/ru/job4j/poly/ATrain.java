package ru.job4j.poly;

public class ATrain implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Движется по рельсам");
    }
}
