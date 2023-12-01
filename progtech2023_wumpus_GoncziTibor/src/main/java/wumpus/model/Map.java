package wumpus.model;

import java.util.Arrays;
import java.util.Objects;

public class Map {
    private int size;
    private char[][] map;
    private Player player;



    public Map(int size, char[][] map, Player player) {
        this.size = size;
        this.map = map;
        this.player = player;
    }

    public Map() {
    }

    public int getSize() {
        return size;
    }

    public char[][] getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setPlayerDirection(char direction) {
        player.setDirection(direction);
    }

    public String getPlayerPosition() {
        return player.getCurrentPosition();
    }

    public int getPlayerGold(){
        return player.getCurrentGold();
    }

    public int getPlayerStepCount(){
        return player.getStepCount();
    }

    // További műveletek hozzáadása, például Map inicializálása, térkép kirajzolása, stb.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Map map1 = (Map) o;
        return size == map1.size && Arrays.equals(map, map1.map) && Objects.equals(player, map1.player);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, player);
        result = 31 * result + Arrays.hashCode(map);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Player{");
        sb.append("size=").append(size);
        sb.append(", map=").append(map == null ? "null" : Arrays.asList(map).toString());
        sb.append(", player=").append(player);
        sb.append('}');
        return sb.toString();
    }
}
