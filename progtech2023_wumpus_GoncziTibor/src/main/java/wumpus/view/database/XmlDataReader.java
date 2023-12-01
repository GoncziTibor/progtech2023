package wumpus.view.database;

import wumpus.view.database.GameData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlDataReader {

    public static GameData loadGameData(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(GameData.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Betölti az adatokat XML-ből
            return (GameData) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("Hiba az adatok betöltése közben.");
            return null;
        }
    }

    public static void main(String[] args) {
        // Példa adatok betöltése XML-ből
        GameData loadedData = loadGameData("gameData.xml");
        if (loadedData != null) {
            // Állítsd be a játék adatait...
        }
    }
}
