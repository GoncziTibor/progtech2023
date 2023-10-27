package wumpus;

import wumpus.model.MapVO;
import wumpus.model.UserVO;
import wumpus.view.map.MapRead1;
import wumpus.view.map.MapRead2;
import wumpus.view.map.Map;
import wumpus.view.menu.Menu;
import wumpus.view.menu.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Üdvözöllek a Wumpus nevezetű játékban.");

        String userName = User.getUsername();
        User.greetUser(userName);

        Menu menu = new Menu();
        UserVO userVO = new UserVO();
        MapVO map = null;

        boolean game = false;
        boolean gameReady = false;

        menu.mainMenu();
        while (!game){
            int answer = menu.getUserAnswer();

            switch (answer) {
                case 1:
                    gameReady = true;
                    menu.mapEditing();
                    if(gameReady = false){
                        menu.mainMenu();
                    }
                    break;
                case 2:
                    gameReady = true;
                    gameStart1();
                    break;
                case 3:
                    //folyamatban
                    gameReady = true;
                    break;
                case 4:
                    //folyamatban
                    break;
                case 5:
                    gameReady = true;
                    System.out.println("Jó játékot kívánok!");
                    menu.gameMenu();
                    gameStart2();
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

    private static void gameStart1() {
        MapRead1 map = new MapRead1("src/main/resources/wumpuszinput.txt");
    }

    private static void gameStart2(){
        Map map = new Map("src/main/resources/wumpuszinput.txt");
    }

}
