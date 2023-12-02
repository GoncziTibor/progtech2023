package wumpus.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayerTest {

    @Test
    void testMove() {
        // GIVEN
        char[][] mapData = {
                {'_', '_', '_'},
                {'_', 'P', '_'},
                {'_', '_', '_'}
        };
        Map map = new Map(3, mapData, null);
        Player player = new Player('B', 1, 'N', 0, 0, map);

        // WHEN
        player.move();

        // THEN
        assertEquals(0, player.getRow());
        assertEquals(1, player.getColumn());
        assertEquals(1, player.getStepCount());
        assertEquals('N', player.getDirection());
        assertEquals(map, player.getMap());

        assertEquals('H', map.getMap()[0][1]);
        assertEquals('_', map.getMap()[1][1]);
    }

    @Test
    void testTurnLeft() {
        // GIVEN
        Player player = new Player('A', 0, 'N', 0, 0, null);

        // WHEN
        player.turnLeft();

        // THEN
        assertEquals('W', player.getDirection());
    }

    @Test
    void testTurnRight() {
        // GIVEN
        Player player = new Player('A', 0, 'N', 0, 0, null);

        // WHEN
        player.turnRight();

        // THEN
        assertEquals('E', player.getDirection());
    }

    @Test
    void testShoot() {
        // GIVEN
        Player player = new Player('A', 0, 'N', 1, 0, null);

        // WHEN
        player.shoot();

        // THEN
        assertEquals(0, player.getArrows());
    }

    @Test
    void testCollectGold() {
        // GIVEN
        Player player = new Player('A', 0, 'N', 0, 0, null);

        // WHEN
        player.collectGold();

        // THEN
        assertEquals(1, player.getGold());
    }

    @Test
    void testTurnLeftFromNorth() {
        // GIVEN
        Player player = new Player('A', 0, 'N', 0, 0, null);

        // WHEN
        player.turnLeft();

        // THEN
        assertEquals('W', player.getDirection());
    }

    @Test
    void testTurnLeftFromWest() {
        // GIVEN
        Player player = new Player('A', 0, 'W', 0, 0, null);

        // WHEN
        player.turnLeft();

        // THEN
        assertEquals('S', player.getDirection());
    }

    @Test
    void testTurnRightFromEast() {
        // GIVEN
        Player player = new Player('A', 0, 'E', 0, 0, null);

        // WHEN
        player.turnRight();

        // THEN
        assertEquals('S', player.getDirection());
    }

    @Test
    void testTurnRightFromSouth() {
        // GIVEN
        Player player = new Player('A', 0, 'S', 0, 0, null);

        // WHEN
        player.turnRight();

        // THEN
        assertEquals('W', player.getDirection());
    }

    @Test
    void testShootWithWumpus() {
        // GIVEN
        Player player = new Player('A', 0, 'N', 1, 0, null);
        char[][] mapData = {{'_', 'W'}, {'_', '_'}};
        Map map = mock(Map.class);
        when(map.getSize()).thenReturn(2);
        when(map.getMap()).thenReturn(mapData);
        player.setMap(map);

        // WHEN
        player.shoot();

        // THEN
        assertEquals(0, player.getArrows());
    }

    @Test
    void testCollectGoldWhenGoldIsPresent() {
        // GIVEN
        Player player = new Player('A', 0, 'N', 0, 0, null);
        char[][] mapData = {{'_', 'G'}, {'_', '_'}};
        Map map = mock(Map.class);
        when(map.getSize()).thenReturn(2);
        when(map.getMap()).thenReturn(mapData);
        player.setMap(map);

        // WHEN
        player.collectGold();

        // THEN
        assertEquals(1, player.getGold());
    }
}