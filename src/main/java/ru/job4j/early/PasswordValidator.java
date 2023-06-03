package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        for (int i = 0; i < password.length(); i++) {
            int code = password.codePointAt(i);
            if (!Character.isUpperCase(code)) {
                throw new IllegalArgumentException(
                        "Password should contain at least one uppercase letter");
            }
            if (!Character.isLowerCase(code)) {
                throw new IllegalArgumentException(
                        "Password should contain at least one lowercase letter");
            }
            if (!Character.isDigit(code)) {
                throw new IllegalArgumentException(
                        "Password should contain at least one figure");
            }
            if (!password.contains("$") || !password.contains("#")) {
                throw new IllegalArgumentException(
                        "Password should contain at least one special symbol");
            }
        }
        if (!password.contains("qwerty") || !password.contains("12345")
                || !password.contains("password") || !password.contains("admin")
                || !password.contains("user")) {
            throw new IllegalArgumentException(
                    "Password shouldn't contain substrings"
                            + ": qwerty, 12345, password, admin, user");
        }
        return password;
    }
}
