package wumpus.view.database;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class XmlDataSaver {
    public static void saveGameData(GameData gameData, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(GameData.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(gameData, new File(filePath));

            System.out.println("Adatok sikeresen elmentve az XML-be.");
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("Hiba az adatok mentése közben.");
        }
    }

    public static void main(String[] args) {
        //példa adatok
        GameData gameSaveData = new GameData();
        gameSaveData.setPlayerName("John Doe");
        gameSaveData.setVictories(3);

        Map<String, Object> gameData = new HashMap<>();
        gameData.put("playerPosition", "A1");
        gameData.put("arrows", 5);

        gameSaveData.setGameData(gameData);

        saveGameData(gameSaveData, "gameData.xml");
    }
}