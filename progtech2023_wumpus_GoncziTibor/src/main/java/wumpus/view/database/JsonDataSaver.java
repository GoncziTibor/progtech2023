package wumpus.view.database;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonDataSaver {
    public static void saveGameData(GameData gameData, String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(filePath), gameData);

            System.out.println("Adatok sikeresen elmentve JSON-be.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Hiba az adatok mentése közben.");
        }
    }

    public static void main(String[] args) {
        GameData gameSaveData = new GameData();
        gameSaveData.setPlayerName("John Doe");
        gameSaveData.setVictories(3);

        Map<String, Object> gameData = new HashMap<>();
        gameData.put("playerPosition", "A1");
        gameData.put("arrows", 5);

        gameSaveData.setGameData(gameData);

        saveGameData(gameSaveData, "gameData.json");
    }
}
