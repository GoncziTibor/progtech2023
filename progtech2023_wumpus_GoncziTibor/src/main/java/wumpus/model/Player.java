package wumpus.model;

import wumpus.view.map.MapRowAndColumn;
import wumpus.view.menu.Menu;

public class Player implements PlayerInterface{
    private int column;
    private int row;
    private char direction;
    private int arrows;
    private int gold;
    private Map map;


    public String getCurrentPosition() {
        return "" + (char) ('A' + this.getColumn()) + " oszlop " + (this.getRow() +1) + ". sor";
    }

    public int getCurrentGold(){
        return this.gold;
    }

    public Player(char column, int row, char direction, int arrows, int gold, Map map) {
        this.column = column;
        this.row = row;
        this.direction = direction;
        this.arrows = arrows;
        this.gold = gold;
        this.map = map;
    }

    public Player() {
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Map getMap(){
        return map;
    }

    public void setMap(Map map){
        this.map = map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (column != player.column) return false;
        if (row != player.row) return false;
        if (direction != player.direction) return false;
        if (arrows != player.arrows) return false;
        return gold == player.gold;
    }

    // További műveletek hozzáadása, például Player mozgatása, lövés, stb.

    @Override
    public int hashCode() {
        int result = column;
        result = 31 * result + row;
        result = 31 * result + (int) direction;
        result = 31 * result + arrows;
        result = 31 * result + gold;
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Player{");
        sb.append("column=").append(column);
        sb.append(", row=").append(row);
        sb.append(", direction=").append(direction);
        sb.append(", arrows=").append(arrows);
        sb.append(", gold=").append(gold);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void move() {
        map.getMap()[this.row][this.column] = '_';

        int newRow = this.row;
        int newColumn = this.column;

        switch (direction) {
            case 'E':
                newColumn++;
                break;
            case 'S':
                newRow++;
                break;
            case 'W':
                newColumn--;
                break;
            case 'N':
                newRow--;
                break;
        }

        // Ellenőrizzük, hogy az új mező a pályán belül van-e és nem fal
        if (isValidMove(newRow, newColumn)) {
            // Ellenőrizzük, hogy van-e wumpus (U) az új mezőn
            if (map.getMap()[newRow][newColumn] == 'U') {
                System.out.println("MEGHALTÁL! A wumpus megölt téged. A játék véget ért.");
                map.getMap()[this.row][this.column] = '_'; // Régi pozícióra írjuk az alapértelmezett jellemzőt
                this.row = newRow;
                this.column = newColumn;
                map.getMap()[this.row][this.column] = 'H'; // Új pozícióra állítjuk a 'H'-t
                // Kezdd újra a játékot vagy végezd el a szükséges lépéseket a játék újrakezdéséhez
            } else if (map.getMap()[newRow][newColumn] == 'P') {
                if (this.arrows > 0) {
                    this.arrows--; // Ha van verem, veszítünk egy nyilat
                    System.out.println("Ez egy verem! Elvesztettél egy nyilat. Új nyilak száma: " + this.arrows);
                    map.getMap()[this.row][this.column] = '_'; // Régi pozícióra írjuk az alapértelmezett jellemzőt
                    this.row = newRow;
                    this.column = newColumn;
                    map.getMap()[this.row][this.column] = 'H'; // Új pozícióra állítjuk a 'H'-t
                } else {
                    System.out.println("Nincs több nyilad. Nem léphetsz a verembe!");
                }
            } else {
                this.row = newRow;
                this.column = newColumn;
                map.getMap()[this.row][this.column] = 'H'; // Új pozícióra állítjuk a 'H'-t
            }
        }

        map.getMap()[this.row][this.column] = 'H'; // Új pozíció beállítása H-re
        MapRowAndColumn.mapPrinter(map); // Pálya kiírása a mozgás után
    }

    @Override
    public void turnRight() {
        // Player jobbra fordulásának implementációja
        switch (this.direction){
            case 'E':
                this.direction = 'S';
                break;
            case 'S':
                this.direction = 'W';
                break;
            case 'W':
                this.direction = 'N';
                break;
            case 'N':
                this.direction = 'E';
                break;
        }
    }

    @Override
    public void turnLeft() {
        // Player balra fordulásának implementációja
        switch (this.direction){
            case 'E':
                this.direction = 'N';
                break;
            case 'S':
                this.direction = 'E';
                break;
            case 'W':
                this.direction = 'S';
                break;
            case 'N':
                this.direction = 'W';
                break;
        }
    }

    @Override
    public void shoot() {
        if (arrows > 0) {
            int targetRow = this.row;
            int targetColumn = this.column;

            switch (direction) {
                case 'E':
                    targetColumn++;
                    break;
                case 'S':
                    targetRow++;
                    break;
                case 'W':
                    targetColumn--;
                    break;
                case 'N':
                    targetRow--;
                    break;
            }

            // Ellenőrizd, hogy a célmező a pályán belül van-e és tartalmaz-e Wumpust (U)
            if (isValidMove(targetRow, targetColumn)) {
                if (map.getMap()[targetRow][targetColumn] == 'U') {
                    map.getMap()[targetRow][targetColumn] = '_';
                    System.out.println("Nyíl eltalálta a Wumpust az irányba!");
                } else {
                    System.out.println("A lövés nem talált el senkit.");
                }
            } else {
                System.out.println("A lövés a falnak ütközött.");
            }

            // Csökkentsd a nyilak számát
            arrows--;
            System.out.println("Új nyilak száma: " + arrows);

            // Ellenőrizd, hogy van-e még nyilad
            if (arrows == 0) {
                System.out.println("Nincs több nyilad!");
            }
        } else {
            System.out.println("Nincs több nyilad!");
        }
    }

    @Override
    public void collectGold() {
        // Ellenőrizzük, hogy az adott irányban van-e arany (G)
        int newRow = this.row;
        int newColumn = this.column;

        switch (direction) {
            case 'E':
                newColumn++;
                break;
            case 'S':
                newRow++;
                break;
            case 'W':
                newColumn--;
                break;
            case 'N':
                newRow--;
                break;
        }

        // Ellenőrizzük, hogy az új mező a pályán belül van-e és tartalmaz-e aranyat
        if (isValidMove(newRow, newColumn) && map.getMap()[newRow][newColumn] == 'G') {
            // Ha van arany, gyűjtsük össze
            this.gold++;
            System.out.println("Arany gyűjtve! Ennyi aranyad van most: " + this.gold);
            map.getMap()[this.row][this.column] = '_'; // Régi pozícióra írjuk az alapértelmezett jellemzőt
            this.row = newRow;
            this.column = newColumn;
            map.getMap()[this.row][this.column] = 'H'; // Új pozícióra állítjuk a 'H'-t
        } else {
            System.out.println("Nincs arany az adott irányban.");
        }
    }

    private boolean isValidMove(int newRow, int newColumn) {
        return newRow >= 0 && newRow < map.getSize() &&
                newColumn >= 0 && newColumn < map.getSize() &&
                map.getMap()[newRow][newColumn] != 'W';
    }
}
