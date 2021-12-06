package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 464);
        Book book2 = new Book("The Simpsons", 272);
        Book book3 = new Book("Harry Potter", 432);
        Book book4 = new Book("Head First Java", 720);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getNumber());
        }

        System.out.println(System.lineSeparator() + "Swap book 1 and 4: ");

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getNumber());
        }

        System.out.println(System.lineSeparator() + "Book search: ");

        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName());
            }
        }
    }
}
