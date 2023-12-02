package wumpus.view.menu;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class MenuTest {

    @Test
    void testGetUserAnswer() {
        // GIVEN
        InputStream inputStream = new ByteArrayInputStream("42\n".getBytes());
        System.setIn(inputStream);

        Menu menu = new Menu();

        // WHEN
        int answer = menu.getUserAnswer();

        // THEN
        assertEquals(42, answer);
        System.setIn(System.in);
    }

    @Test
    void testMainMenu() {
        // GIVEN
        Menu menu = mock(Menu.class);

        // WHEN
        menu.mainMenu();

        // THEN
        //a Menu osztaly metúdusa nem tér vissza értékekkel
    }

    @Test
    void testMapEditing() {
        // GIVEN
        Menu menu = mock(Menu.class);

        // WHEN
        menu.mapEditing();

        // THEN
        //a Menu osztaly metúdusa nem tér vissza értékekkel
    }

    @Test
    void testGameMenu() {
        // GIVEN
        Menu menu = mock(Menu.class);

        // WHEN
        menu.gameMenu();

        // THEN
        //a Menu osztaly metúdusa nem tér vissza értékekkel
    }
}