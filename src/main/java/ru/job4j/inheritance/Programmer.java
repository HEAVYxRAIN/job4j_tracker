package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String level;

    public Programmer(String name, String surname, String education, String birthday,
                      String domain, String level) {
        super(name, surname, education, birthday, domain);
        this.level = level;
    }

    public String write(String code) {
        return code;
    }
}
