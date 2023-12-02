package wumpus.view.map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import wumpus.model.Map;
import wumpus.view.exception.MapReaderException;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MapHelpTest {

    @InjectMocks
    private MapHelp underTest;

    @Mock
    private Logger loggerMock;

    @Mock
    private MapReader mapReaderMock;

    @Mock
    private MapRowAndColumn mapRowAndColumnMock;

    @Mock
    private InputStream inputStreamMock;

    @Test
    void testReadMap() throws MapReaderException {
        // GIVEN
        Map expectedMap = new Map();
        when(mapReaderMock.readMap()).thenReturn(expectedMap);

        // WHEN
        Map result = underTest.readMap(inputStreamMock);

        // THEN
        assertNotNull(result);
        assertSame(expectedMap, result);
        verifyNoInteractions(loggerMock);
    }

    @Test
    void testReadMapWhenMapReaderThrowsException() throws MapReaderException {
        // GIVEN
        when(mapReaderMock.readMap()).thenThrow(new MapReaderException("Hiba a térkép olvasása közben"));

        // WHEN
        Map result = underTest.readMap(inputStreamMock);

        // THEN
        assertNull(result);
        verify(loggerMock).error("A pálya beolvasás közben hiba történt!");
    }

    @Test
    void testPrintMap() {
        // GIVEN
        Map map = new Map();
        doNothing().when(mapRowAndColumnMock).mapPrinter(map);

        // WHEN
        underTest.printMap(map);

        // THEN
        verify(mapRowAndColumnMock).mapPrinter(map);
    }
}