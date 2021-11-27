package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Porechnev Vyacheslav");
        student.setGroup("Trainees");
        student.setReceiptDate("24.12.2020");

        System.out.println("Full name : " + student.getFullName() + System.lineSeparator()
                + "Group : " + student.getGroup() + System.lineSeparator()
                + "Receipt Date : " + student.getReceiptDate());
    }
}
