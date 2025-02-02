package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int size) {
        this.load = size;
    }

    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery charge = new Battery(70);
        Battery charger = new Battery(30);
        System.out.println("charge : " + charge.load + ". charger : " + charger.load);
        charge.exchange(charger);
        System.out.println("charge : " + charge.load + ". charger : " + charger.load);
    }
}
