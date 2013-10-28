package ru.kirkazan.itis.poker.game;

import java.util.List;

/**
 * @author esadykov
 * @since 27.10.13 23:01
 */
public class Table {

    /*
    todo
    Количество рук за столом не превышает 9. Необходимо реализовать на уровне модели и отразить в тестах
     */

    public static final int SIZE = 9;

    private List<Hand> hands;

    public List<Hand> getHands() {
        return hands;
    }
}
