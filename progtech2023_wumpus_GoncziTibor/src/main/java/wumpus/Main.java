package wumpus;

import wumpus.view.menu.Menu;
import wumpus.view.menu.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        System.out.println("Üdvözüllek a Wumpus nevezetű játékban.");

        String userName = User.getUsername();
        User.greetUser(userName);

        Menu menu = new Menu();

        boolean game = false;
        boolean gameReady = false;

        while (!game){
            int answer = menu.getUserAnswer();

            switch (answer) {
                case 1:
                    menu.mapEditing();
                    gameReady = true;
                    break;
                case 2:

                case 3:
                    //folyamatban
                    gameReady = true;
                    break;
                case 4:
                    //folyamatban
                    break;
                case 5:
                    if(gameReady){
                        menu.gameMenu();
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
