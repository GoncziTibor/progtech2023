package wumpus;

import wumpus.view.map.MapManager;
import wumpus.view.map.MapWriter;
import wumpus.view.menu.Menu;
import wumpus.view.menu.User;
import wumpus.model.Map;

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

        boolean exit = false;
        boolean game = false;
        boolean read = false;

        menu.mainMenu();
        while (!exit){
            int answer = menu.getUserAnswer();

            switch (answer) {
                case 1:
                    //elég csak az egyiket implementálni
                    boolean mapEditor = true;
                    System.out.println("Válassz egy menüt pontot!:");
                    menu.mapEditing();
                    break;
                case 2:
                    MapManager mapManager = new MapManager();
                    File file = new File("src/main/resources/wumpuszinput.txt");
                    InputStream inputStream = new FileInputStream(file);
                    map = mapManager.readMap(inputStream);
                    MapWriter.printMapAndHeroDetails(map);
                    game = true;
                    break;
                case 3:
                    //folyamatban (2. fázis)
                    game = true;
                    break;
                case 4:
                    //folyamatban (2. fázis)
                    game= true;
                    break;
                case 5:
                    if (game) {
                        int gameAnswer;
                        boolean gameMenu = true;
                        menu.gameMenu();

                        while (gameMenu) {
                            gameAnswer = menu.getUserAnswer();
                            System.out.println("Válassz egy menüt pontot!:");
                            switch (gameAnswer) {
                                case 1:
                                    map.getPlayer().move();
                                    MapWriter.printMapAndHeroDetails(map);
                                    break;
                                case 2:
                                    map.getPlayer().turnRight();
                                    MapWriter.printMapAndHeroDetails(map);
                                    break;
                                case 3:
                                    map.getPlayer().turnLeft();
                                    MapWriter.printMapAndHeroDetails(map);
                                    break;
                                case 4:
                                    map.getPlayer().shoot();
                                    MapWriter.printMapAndHeroDetails(map);
                                    break;
                                case 5:
                                    map.getPlayer().gold();
                                    MapWriter.printMapAndHeroDetails(map);
                                    break;
                                case 6:
                                    gameMenu = false;
                                    menu.mainMenu();
                                    break;
                                case 7:
                                    //halasztás
                                default:
                                    System.out.println("Olyan menüpontot választottál ami nem létezik, kérlek válassz újra!");
                                    break;
                            }
                        }
                    } else {
                        //csak a fájlból beolvasás van implementálva
                        System.out.println("Válaszd ki előszőr a fájlból beolvasás lehetőségét! (2)");
                    }
                    break;
                case 6:
                    System.out.println("Kilépés kiválasztva!");
                    System.out.println("Viszlát " + userName + " ");
                    System.exit(0);
                default:
                    System.out.println("Olyan menüpontot választottál ami nem létezik, kérlek válassz újra!");


            }

        }
    }
}