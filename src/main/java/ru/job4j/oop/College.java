package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        StudentTwo stud = freshman;
        Object obj = freshman;
        System.out.println(new Freshman());
        System.out.println(new StudentTwo());
    }
}
