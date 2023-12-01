package wumpus.view.database;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlDataReader {

    public static GameData loadGameData(String filePath) {
        try {
            File file = new File(filePath);
            JAXBContext context = JAXBContext.newInstance(GameData.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            return (GameData) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("Hiba az adatok betöltése közben.");
            return null;
        }
    }

    public static void main(String[] args) {
        // Példa adatok betöltése XML-ből
        GameData loadedGameData = loadGameData("gameData.xml");
        if (loadedGameData != null) {
            // A betöltött adatok használata
            System.out.println("Betöltött adatok: " + loadedGameData);
        }
    }
}