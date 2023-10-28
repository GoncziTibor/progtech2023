package wumpus;

import wumpus.view.menu.Menu;
import wumpus.view.menu.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Üdvözöllek a Wumpus nevezetű játékban.");

        String userName = User.getUsername();
        User.greetUser(userName);

        Menu menu = new Menu();

        boolean exit = false;
        boolean game = false;

        menu.mainMenu();
        while (!exit){
            int answer = menu.getUserAnswer();

            switch (answer) {
                case 1:
                    game = true;
                    menu.mapEditing();
                    if(game = false){
                        menu.mainMenu();
                    }
                    break;
                case 2:
                    game = true;
                    break;
                case 3:
                    //folyamatban
                    game = true;
                    break;
                case 4:
                    //folyamatban
                    break;
                case 5:
                    game = true;
                    System.out.println("Jó játékot kívánok!");
                    menu.gameMenu();
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
