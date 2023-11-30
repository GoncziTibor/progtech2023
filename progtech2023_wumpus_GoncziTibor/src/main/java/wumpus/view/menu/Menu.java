package wumpus.view.menu;

import java.util.Scanner;

public class Menu {

    public Scanner scanner;
    public Menu(){
        this.scanner = new Scanner(System.in);
    }
    public int getUserAnswer(){
        return scanner.nextInt();
    }

    public void mainMenu(){
        //pályaszerkesztés és a fájból beolvasás közül elég az egyiket implementálni
        System.out.println("- Itt vagy: Főmenü -");
        System.out.println("1. (Pályaszerkesztés)");
        System.out.println("2. Fájlból beolvasás");
        System.out.println("3. (Adatbázisból betöltés)"); //ezt csak a 2. fázisban
        System.out.println("4. (Adatbázisba mentés)"); //ezt csak a 2.fázisban
        System.out.println("5. Játék");
        System.out.println("6 .Kilépés");
    }

    public void mapEditing(){
        System.out.println("- Itt vagy: Pályaszerkesztés -");
        System.out.println("1. Szerkesztés");
        System.out.println("2. Mentés");
        System.out.println("3. Kilépés");
    }

    public void gameMenu(){
        System.out.println("- Itt vagy: Játékmenü -");
        System.out.println("1. Lépés");
        System.out.println("2. Fordulás balra");
        System.out.println("3. Fordulás jobbra");
        System.out.println("4. Lövés");
        System.out.println("5. Arany felvétele");
        System.out.println("6. Felad");
        System.out.println("7. Halasztás");
    }

}
