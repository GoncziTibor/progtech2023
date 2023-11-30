package wumpus.view.map;

import wumpus.model.Map;
import wumpus.model.Player;
import wumpus.view.exception.MapReaderException;


import java.io.BufferedReader;
import java.io.IOException;

public class MapReader implements MapReaderInterface {

    private final BufferedReader bufferedReader;

    public MapReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public Map readMap() throws MapReaderException {
        try {
            String firstLine = bufferedReader.readLine();
            String[] firstLineParts = firstLine.split(" ");

            if (firstLineParts.length != 4) {
                throw new MapReaderException("Hibás első sor formátum: " + firstLine);
            }

            int size = Integer.parseInt(firstLineParts[0]);
            char playerColumn = (char) (firstLineParts[1].charAt(0) - 'A');
            int playerRow = Integer.parseInt(firstLineParts[2]);
            char direction = firstLineParts[3].charAt(0);
            int gold = 0;
            int wumpusCounter = 0;
            char[][] map = new char[size][size];

            for (int i = 0; i < size; i++) {
                String row = bufferedReader.readLine();
                for (int j = 0; j < size; j++) {
                    map[i][j] = row.charAt(j);
                    if (row.charAt(j) == 'U') {
                        wumpusCounter++;
                    }
                }
            }
            map[playerRow - 1][playerColumn] = 'H';

            Map mapvo = new Map(size, map, null);
            Player player = new Player(playerColumn, playerRow , direction, wumpusCounter, gold, mapvo);
            player.setMap(mapvo);
            mapvo.setPlayer(player);

            return mapvo;
            //mapvo = new Map(size, map, player);
        } catch (IOException exc) {
            exc.printStackTrace(); // PrintStackTrace hozzáadva a hibakereséshez
            throw new MapReaderException("A pálya beolvasás sikertelen!");
        }
    }
}
