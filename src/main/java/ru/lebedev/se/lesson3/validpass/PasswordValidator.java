package ru.lebedev.se.lesson3.validpass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    private static final String PASSWORD_PATTERN =
            "(?=^[a-zA-Z0-9!@#$&%_-]{8,}$)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$&%])(?=.*\\d).*$";

    private final Pattern pattern;
    private Matcher matcher;

    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    public boolean validate(String password) {
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
