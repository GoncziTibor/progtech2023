package wumpus.model;

public class Map {
    private int size;
    private char[][] map;
    private Player player;

    public Map(int size, char[][] map, Player player) {
        this.size = size;
        this.map = map;
        this.player = player;
    }
}
