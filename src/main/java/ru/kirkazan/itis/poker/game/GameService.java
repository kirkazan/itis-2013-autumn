package ru.kirkazan.itis.poker.game;

import java.util.ArrayList;

/**
 * @author esadykov
 * @since 27.10.13 23:57
 */
public class GameService {

    private Table table = new Table();

    public JoinResult join(User user) {
        Integer index = getFirstSpace();
        if (index == null)
            return JoinResult.IN_QUEUE;
        return JoinResult.SUCCESS;
    }

    protected Integer getFirstSpace() {
        for (int i = 0; i < Table.SIZE; i++) {
            if (table.getHands().get(i) == null)
                return i;
        }
        return null;
    }
}
