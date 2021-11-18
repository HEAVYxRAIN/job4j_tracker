package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String experience;

    public Builder(String name, String surname, String education, String birthday, String domain,
                   String experience) {
        super(name, surname, education, birthday, domain);
        this.experience = experience;
    }

    public String build(String object) {
        return object;
    }
}
