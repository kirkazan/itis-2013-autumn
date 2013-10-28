package ru.kirkazan.itis.poker.game;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.internal.util.collections.ListUtil;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author esadykov
 * @since 27.10.13 23:50
 */
@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @InjectMocks
    @Spy
    private GameService gameService = new GameService();

    @Mock
    private Table table;

    @Test
    public void join() {

        JoinResult result;
        User user = new User();

        when(table.getHands()).thenReturn(getPopulatedHands(new Hand()));
        result = gameService.join(user);
        assertEquals(JoinResult.IN_QUEUE, result);
        verify(gameService, times(1)).getFirstSpace();

        when(table.getHands()).thenReturn(getPopulatedHands(null));
        result = gameService.join(user);
        assertEquals(JoinResult.SUCCESS, result);
        verify(gameService, times(2)).getFirstSpace();

        /*
        todo

        Проверить что пользователь уже не за столом
        Проверить что пользователь сел за стол


         */

    }

    private List<Hand> getPopulatedHands(Hand hand) {
        List<Hand> hands = new ArrayList<Hand>(Table.SIZE);
        for (int i = 0; i < Table.SIZE; i++) {
            hands.add(hand);
        }
        return hands;
    }

}
