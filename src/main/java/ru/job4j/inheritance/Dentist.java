package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private String tooth;

    public Dentist(String name, String surname, String education, String birthday, String category,
                   String tooth) {
        super(name, surname, education, birthday, category);
        this.tooth = tooth;
    }

    public String heals(String teeth) {
        return teeth;
    }
}
