package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String category;

    public Doctor(String name, String surname, String education, String birthday, String category) {
        super(name, surname, education, birthday);
        this.category = category;
    }

    public String save(String health) {
        return health;
    }

    public String getCategory() {
        return category;
    }
}
