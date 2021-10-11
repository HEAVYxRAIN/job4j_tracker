package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int size) {
        this.load = size;
    }

    public void exchange(Battery another) {
        this.load = this.load - another.load;
        another.load = 0;
    }

    public static void main(String[] args) {
        Battery charge = new Battery(100);
        Battery discharged = new Battery(30);
        System.out.println("charge : " + charge.load + ". discharged : " + discharged.load);
        charge.exchange(discharged);
        System.out.println("charge : " + charge.load + ". discharged : " + discharged.load);
    }
}
