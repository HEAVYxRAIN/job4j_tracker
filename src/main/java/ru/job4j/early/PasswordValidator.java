package ru.job4j.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        for (String value : FORBIDDEN) {
            if (password.toLowerCase().contains(value) || password.toUpperCase().contains(value)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty,"
                        + " 12345, password, admin, user");
            }
        }
        boolean hasUpCase;
        boolean hasLowCase;
        boolean hasDigit;
        boolean hasSpecial;
        for (char symbol : password.toCharArray()) {
            hasUpCase = Character.isUpperCase(symbol);
            if (!hasUpCase) {
                throw new IllegalArgumentException(
                        "Password should contain at least one uppercase letter");
            }
            hasLowCase = Character.isLowerCase(symbol);
            if (!hasLowCase) {
                throw new IllegalArgumentException(
                        "Password should contain at least one lowercase letter");
            }
            hasDigit = Character.isDigit(symbol);
            if (!hasDigit) {
                throw new IllegalArgumentException(
                        "Password should contain at least one figure");
            }
            hasSpecial = Character.isLetterOrDigit(symbol);
            if (!hasSpecial) {
                throw new IllegalArgumentException(
                        "Password should contain at least one special symbol");
            }
        }
        return password;
    }
}
