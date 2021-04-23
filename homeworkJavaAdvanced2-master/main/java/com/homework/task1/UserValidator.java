package com.homework.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    private String email;
    private String alternativeEmail;

    public UserValidator(String email, String alternativeEmail) {
        this.email = validateEmail(email);
        this.alternativeEmail = validateEmail(alternativeEmail);
    }

    public String getEmail() {
        return email;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    @Override
    public String toString() {
        return "{" +
                "email='" + email + '\'' +
                ", alternativeEmail='" + alternativeEmail + '\'' +
                '}';
    }

    public String validateEmail(String anotherEmail) {
        String finalAnotherEmail = anotherEmail;
        class Email {
            public boolean formatter() {
                String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(finalAnotherEmail);
                return matcher.find();
            }
        }

        Email formattedEmail = new Email();

        if (anotherEmail == null || anotherEmail == "") {
            anotherEmail = "unknown";
        } else if (!formattedEmail.formatter()) {
            anotherEmail = "unknown";
        } else {
            return anotherEmail;
        }

        return anotherEmail;
    }
}
