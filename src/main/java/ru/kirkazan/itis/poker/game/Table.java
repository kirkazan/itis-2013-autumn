package ru.kirkazan.itis.poker.game;

import java.util.List;

/**
 * @author esadykov
 * @since 27.10.13 23:01
 */
public class Table {

    public static final int SIZE = 9;

    String id;
    List<User> users;
    private List<Hand> hands;

    public List<Hand> getHands() {
        return hands;
    }
}
