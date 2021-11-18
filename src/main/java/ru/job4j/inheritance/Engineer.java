package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String domain;

    public Engineer(String name, String surname, String education, String birthday, String domain) {
        super(name, surname, education, birthday);
        this.domain = domain;
    }

    public String repairs(String result) {
        return result;
    }

    public  String getDomain() {
        return domain;
    }
}
