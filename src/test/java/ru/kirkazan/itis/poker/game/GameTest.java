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
        User user = new User("testname");

        when(table.getHands()).thenReturn(getPopulatedHands(new Hand(user)));
        result = gameService.join(user);
        assertEquals(JoinResult.IN_QUEUE, result);

        when(table.getHands()).thenReturn(getPopulatedHands((Hand) null));
        result = gameService.join(user);
        assertEquals(JoinResult.SUCCESS, result);


        /*
        todo

        Проверить что пользователь уже не за столом
        Проверить что пользователь сел за стол


         */

        String existingUserName = "existingUser";
        User existingUser = new User(existingUserName);

        when(table.getHands()).thenReturn(getPopulatedHands(new Hand(user),new Hand(user),new Hand(existingUser),new Hand(user)));
        result = gameService.join(existingUser);
        assertEquals(JoinResult.SUCCESS, result);

        when(table.getHands()).thenReturn(getPopulatedHands(new Hand(user),new Hand(existingUser),new Hand(user),new Hand(user)
                ,new Hand(user),new Hand(user),new Hand(user),new Hand(user),new Hand(user)));
        result = gameService.join(existingUser);
        assertEquals(JoinResult.SUCCESS, result);

    }

    private List<Hand> getPopulatedHands(Hand... ahands) {
        List<Hand> hands = new ArrayList<Hand>(Table.SIZE);
        for (int i = 0; i < Table.SIZE; i++) {
            if (ahands.length > i)
                hands.add(ahands[i]);
            else
                hands.add(null);
        }
        return hands;
    }

}
