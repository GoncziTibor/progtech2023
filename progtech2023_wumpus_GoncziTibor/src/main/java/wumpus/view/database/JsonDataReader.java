package wumpus.view.database;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonDataReader {
    public static GameData loadGameData(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            GameData gameData = objectMapper.readValue(new File(filePath), GameData.class);

            System.out.println("Adatok sikeresen betöltve JSON-ből.");
            return gameData;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Hiba az adatok betöltése közben.");
            return null;
        }
    }

    public static void main(String[] args) {
        GameData loadedGameData = loadGameData("gameData.json");

        if (loadedGameData != null) {
            System.out.println("Player Name: " + loadedGameData.getPlayerName());
            System.out.println("Victories: " + loadedGameData.getVictories());
        }
    }
}
