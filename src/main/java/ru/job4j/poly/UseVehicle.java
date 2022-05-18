package ru.job4j.poly;

public class UseVehicle {
    public static void main(String[] args) {

        Vehicle airplane = new Airplane();
        Vehicle atrain = new ATrain();
        Vehicle autoBus = new AutoBus();

        Vehicle[] vehicles = new Vehicle[]{airplane, atrain, autoBus};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
