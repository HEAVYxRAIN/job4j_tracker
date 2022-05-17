package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Добро пожаловать в автобус №891");
    }

    @Override
    public void passengers(int amount) {
        System.out.println("Колличество пассажиров: " + amount + " человек");
    }

    @Override
    public int refuel(int liter, int price) {
        return liter * price;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.drive();
        bus.passengers(45);
        int ticket = bus.refuel(5, 53);
        System.out.println("Стоимость проезда составляет: " + ticket + " рублей");
    }
}
