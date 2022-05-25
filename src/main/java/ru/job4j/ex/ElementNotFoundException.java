package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(String message) {
        super(message);
    }

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
            if (rsl == -1) {
                throw new ElementNotFoundException("Не верный элемент");
            }
        }
        return rsl;
    }

    public static void main(String[] args) throws ElementNotFoundException {
        String[] arr = {"1", "2", "3"};
        try {
            indexOf(arr, "5");
        } catch (ElementNotFoundException el) {
            el.printStackTrace();
        }
    }
}
