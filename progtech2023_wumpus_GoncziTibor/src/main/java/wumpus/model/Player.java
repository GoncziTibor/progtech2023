package wumpus.model;

public class Player {
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
}
