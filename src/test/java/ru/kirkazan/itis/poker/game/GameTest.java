package ru.kirkazan.itis.poker.game;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.internal.util.collections.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author esadykov
 * @since 27.10.13 23:50
 */
public class GameTest {

    @Test
    public void getFirstSpace() {
        GameService gameService = spy(new GameService());
        Table table = mock(Table.class);
        when(gameService.getTable()).thenReturn(table);
        Integer firstSpaceIndex;


        List<Hand> noTableHands = getPopulatedHands(null);
        when(table.getHands()).thenReturn(noTableHands);
        firstSpaceIndex = gameService.getFirstSpace();
        assertEquals(Integer.valueOf(0), firstSpaceIndex);

        List<Hand> fullTableHands = getPopulatedHands(new Hand());
        when(table.getHands()).thenReturn(fullTableHands);
        firstSpaceIndex = gameService.getFirstSpace();
        assertNull(firstSpaceIndex);
    }

    @Test
    public void join() {
        GameService gameService = spy(new GameService());
        Table table = mock(Table.class);
        User user = mock(User.class);

        JoinResult result;

        List<Hand> fullTableHands = getPopulatedHands(new Hand());
        when(table.getHands()).thenReturn(fullTableHands);
        result = gameService.join(user);
        assertEquals(JoinResult.IN_QUEUE,result);

        List<Hand> noTableHands = getPopulatedHands(null);
        when(table.getHands()).thenReturn(noTableHands);
        result = gameService.join(user);
        assertEquals(JoinResult.SUCCESS,result);
    }

    private List<Hand> getPopulatedHands(Hand hand){
        List<Hand> hands = new ArrayList<Hand>(Table.SIZE);
        for(int i = 0; i<Table.SIZE; i++)
        {
            hands.add(hand);
        }
        return hands;
    }

}
