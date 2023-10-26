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

    public void mainMenu(){
        //pályaszerkesztés és a fájból beolvasás közül elég az egyiket implementálni
        System.out.println("(Pályaszerkesztés)");
        System.out.println("Fájlból beolvasás");
        System.out.println("(Adatbázisból betöltés)"); //ezt csak a 2. fázisban
        System.out.println("(Adatbázisba mentés)"); //ezt csak a 2.fázisban
        System.out.println("Játszás");
        System.out.println("Kilépés");
    }

    public void mapEditing(){
        System.out.println("Szerkesztés");
        System.out.println("Kilépés");
    }

    public void gameMenu(){
        System.out.println("Lépés");
        System.out.println("Fordulás balra");
        System.out.println("Fordulás jobbra");
        System.out.println("Lövés");
        System.out.println("Arany felvétele");
        System.out.println("Felad");
        //System.out.println("Halasztás");
    }

}
