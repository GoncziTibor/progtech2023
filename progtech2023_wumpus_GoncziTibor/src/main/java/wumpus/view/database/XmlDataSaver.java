package wumpus.view.database;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class XmlDataSaver {

    public static void saveGameData(GameData gameData, String filePath) {
        try {
            File file = new File(filePath);
            JAXBContext context = JAXBContext.newInstance(GameData.class);
            Marshaller marshaller = context.createMarshaller();

            // Formázott kimenet
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Menti az adatokat XML-be
            marshaller.marshal(gameData, file);

            System.out.println("Adatok sikeresen elmentve az XML-be.");
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("Hiba az adatok mentése közben.");
        }
    }

    public static void main(String[] args) {
        // Példa adatok létrehozása és mentése XML-be
        GameData gameData = new GameData();
        // Állítsd be a játék adatait...

        saveGameData(gameData, "gameData.xml");
    }
}