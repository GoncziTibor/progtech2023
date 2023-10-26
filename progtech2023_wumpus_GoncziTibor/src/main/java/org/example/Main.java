package org.example;

import org.example.view.menu.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Üdvözüllek a Wumpus nevezetű játékban.");

        String userName = User.getUsername();
        User.greetUser(userName);
    }
}
