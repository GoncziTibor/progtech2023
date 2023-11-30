package wumpus.model;

public class Player implements PlayerInterface{
    private char column;
    private int row;
    private char direction;
    private int arrows;
    private int gold;

    public Player(char column, int row, char direction, int arrows, int gold) {
        this.column = column;
        this.row = row;
        this.direction = direction;
        this.arrows = arrows;
        this.gold = gold;
    }

    public Player() {
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
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
        // Player mozgatásának implementációja
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
        System.out.println("Fordultál jobbra. Új irány: " + this.direction);
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
        System.out.println("Fordultál balra. Új irány: " + this.direction);
    }

    @Override
    public void shoot() {
        // Player lövésének implementációja
        this.arrows--;
    }

    @Override
    public void collectGold() {
        // Player aranyfelveszésének implementációja
    }
}
