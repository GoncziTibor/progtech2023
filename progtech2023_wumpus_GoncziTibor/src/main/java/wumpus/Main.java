package wumpus;

import wumpus.model.Map;
import wumpus.view.database.*;
import wumpus.view.map.MapHelp;
import wumpus.view.map.MapRowAndColumn;
import wumpus.view.menu.Menu;
import wumpus.view.menu.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Üdvözöllek a Wumpus nevezetű játékban.");

        String userName = User.getUsername();
        User.greetUser(userName);

        System.out.println("Válassz egy menüt pontot!:");

        Menu menu = new Menu();
        Map map = new Map();
        MapHelp mapHelp = new MapHelp();

        EntityManager entityManager = Persistence.createEntityManagerFactory("my-persistence-unit").createEntityManager();
        DatabaseLoader databaseLoader = new DatabaseLoader(entityManager);
        DatabaseSaver databaseSaver = new DatabaseSaver(entityManager);


        boolean exit = false;
        boolean game = false;

        menu.mainMenu();
        while (!exit) {
            int answer = menu.getUserAnswer();

            switch (answer) {
                case 1:
                    // Elég csak az egyiket implementálni
                    boolean mapEditorMenu = true;
                    //System.out.println("Válassz egy menüt pontot!:");
                    menu.mapEditing();

                    while(mapEditorMenu){
                            int answerMapEditor = menu.getUserAnswer();
                            switch (answerMapEditor) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    mapEditorMenu = false;
                                    menu.mainMenu();
                            }
                    }
                    break;
                case 2:
                    File file = new File("src/main/resources/wumpuszinput.txt");
                    InputStream inputStream = new FileInputStream(file);
                    map = mapHelp.readMap(inputStream);
                    MapRowAndColumn.printMapAndPlayerInfo(map);
                    game = true;
                    break;
                case 3:
                    String playerNameForLoad = User.getUsername();
                    GameData loadedGameData = databaseLoader.loadGameData(playerNameForLoad);
                    break;
                case 4:
                    PlayerData playerToSave = new PlayerData();
                    playerToSave.setPlayerName("John Doe");
                    playerToSave.setVictories(3);

                    GameData gameData = new GameData();
                    gameData.setPlayerName(playerToSave.getPlayerName());
                    gameData.setVictories(playerToSave.getVictories());
                    // Egyéb GameData információk beállítása...

                    databaseSaver.saveGameData(gameData);
                    break;
                case 5:
                    if (game) {
                        boolean gameMenu = true;
                        menu.gameMenu();

                        while (gameMenu) {
                            int gameAnswer = menu.getUserAnswer();
                            System.out.println("Válassz egy menü pontot!:");

                            switch (gameAnswer) {
                                case 1:
                                    map.getPlayer().move();
                                    MapRowAndColumn.printMapAndPlayerInfo(map);
                                    break;
                                case 2:
                                    map.getPlayer().turnLeft();
                                    char newDirectionLeft = map.getPlayer().getDirection();
                                    map.setPlayerDirection(newDirectionLeft);
                                    MapRowAndColumn.printMapAndPlayerInfo(map);
                                    break;
                                case 3:
                                    map.getPlayer().turnRight();
                                    char newDirectionRight = map.getPlayer().getDirection();
                                    map.setPlayerDirection(newDirectionRight);
                                    MapRowAndColumn.printMapAndPlayerInfo(map);
                                    break;
                                case 4:
                                    map.getPlayer().shoot();
                                    MapRowAndColumn.printMapAndPlayerInfo(map);
                                    break;
                                case 5:
                                    map.getPlayer().collectGold();
                                    MapRowAndColumn.printMapAndPlayerInfo(map);
                                    break;
                                case 6:
                                    gameMenu = false;
                                    menu.mainMenu();
                                    break;
                                case 7:
                                    // Halasztás: a fő switch case 3. részénél van megoldva
                                default:
                                    System.out.println("Ismeretlen parancs. Próbáld újra!");
                                    System.out.println("Olyan menüpontot választottál, ami nem létezik, kérlek válassz újra!");
                                    break;
                            }
                            MapRowAndColumn.printMapAndPlayerInfo(map);
                        }
                    } else {
                        // Csak a fájlból beolvasás van implementálva
                        System.out.println("Válaszd ki először a fájlból beolvasás lehetőségét! (2)");
                    }
                    break;
                case 6:
                    System.out.println("Kilépés kiválasztva!");
                    System.out.println("Viszlát " + userName + " ");
                    System.exit(0);
                default:
                    System.out.println("Olyan menüpontot választottál, ami nem létezik, kérlek válassz újra!");
            }
        }
    }
}