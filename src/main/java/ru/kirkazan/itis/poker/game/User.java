package ru.kirkazan.itis.poker.game;

import java.math.BigDecimal;

/**
 * @author esadykov
 * @since 27.10.13 22:57
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
