package com.epam.gym.web.service;

public class IsItFriday {
    public static String isItFriday(String today) {
        return "Friday".equals(today) ? "Yes" : "Nope";
    }
}
