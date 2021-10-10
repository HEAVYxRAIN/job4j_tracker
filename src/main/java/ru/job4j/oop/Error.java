package ru.job4j.oop;

public class Error {

    private boolean active;

    private int status;

    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public void printInfo() {
        System.out.println("Активна: " + active);
        System.out.println("Статус: № " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error(true, 666, "Пригласите священника");
        Error error2 = new Error(true, 2, "Позвоните в полицию");
        Error error3 = new Error();
        error.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
