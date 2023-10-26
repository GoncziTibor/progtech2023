package wumpus;

import wumpus.view.menu.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Üdvözüllek a Wumpus nevezetű játékban.");

        String userName = User.getUsername();
        User.greetUser(userName);

        boolean game = false;

        while (!game){
            int answer =;

            switch (answer) {
                case 1:

                case 2:

                case 3:

                case 4:

                case 5:

                case 6:
            }

        }
    }
}
