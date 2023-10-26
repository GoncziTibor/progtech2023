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

    public void MainMenu(){
        System.out.println("(Pályaszerkesztés)");
        System.out.println("Fájlból beolvasás");
        System.out.println("Adatbázisból betöltés");
        System.out.println("Adatbázisba mentés");
        System.out.println("Játszás");
        System.out.println("Kilépés");
    }
}
