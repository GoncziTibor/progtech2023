package wumpus.view.menu;

import java.util.Scanner;

public class Menu {

    public Scanner scanner;
    public Menu(){
        this.scanner = new Scanner(System.in);
    }
    public int getUserAnswer(){
        System.out.println("Választható menük:");
        return scanner.nextInt();
    }
}
