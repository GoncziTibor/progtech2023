package wumpus.view.menu;

import java.util.Scanner;

public class User {

    private static Scanner scanner = new Scanner(System.in);

    public static String getUsername() {
        System.out.print("Kérlek, adj meg egy felhasználónevet: ");
        return scanner.nextLine();
    }

    public static void greetUser(String userName) {
        System.out.println("Szia " + userName + ", jó játékot!");
    }

    public static void closeScanner() {
        scanner.close();
    }
}
