package wumpus;

import wumpus.view.menu.Menu;
import wumpus.view.menu.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Üdvözüllek a Wumpus nevezetű játékban.");

        String userName = User.getUsername();
        User.greetUser(userName);

        Menu menu = new Menu();

        boolean game = false;

        while (!game){
            int answer = menu.getUserAnswer();

            switch (answer) {
                case 1:

                case 2:

                case 3:

                case 4:

                case 5:

                case 6:
                    game = true;

            }

        }
        System.out.println("Játékból kiléptél!");
    }
}
