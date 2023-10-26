package org.example.view.menu;

import java.util.Scanner;

public class User {
    public static String getUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérlek, adj meg egy felhasználónevet: ");
        return scanner.nextLine();
    }

    public static void greetUser(String username) {
        System.out.println("Szia " + username + "!");
    }
}
