package wumpus.view.database;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Map;

public class XmlDataReader {
    public static GameData loadGameData(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(GameData.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            GameData gameData = (GameData) unmarshaller.unmarshal(new File(filePath));

            System.out.println("Adatok sikeresen betöltve az XML-ből.");
            return gameData;
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("Hiba az adatok betöltése közben.");
            return null;
        }
    }

    public static void main(String[] args) {
        GameData loadedGameData = loadGameData("gameData.xml");

        if (loadedGameData != null) {
            System.out.println("Player Name: " + loadedGameData.getPlayerName());
            System.out.println("Victories: " + loadedGameData.getVictories());

            Map<String, Object> gameData = loadedGameData.getGameData();
            if (gameData != null) {
                System.out.println("Player Position: " + gameData.get("playerPosition"));
                System.out.println("Arrows: " + gameData.get("arrows"));
            }
        }
    }
}
