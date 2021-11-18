package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String top;

    public Surgeon(String name, String surname, String education, String birthday, String category,
                   String top) {
        super(name, surname, education, birthday, category);
        this.top = top;
    }

    public String operation(String succes) {
        return succes;
    }
}
