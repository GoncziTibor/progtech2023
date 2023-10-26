package wumpus.view.map;

import java.io.RandomAccessFile;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class MapRead1 {
    private char map [][];
    private String starterPoint[];
    private char playerWay;
    private int mapSize;

    //beolvasás
    public MapRead1(String file) {
        try{
            RandomAccessFile read = new RandomAccessFile(file, "r");
            String firstRow[] = read.readLine().split(" ");
            this.mapSize = Integer.parseInt(firstRow[0]);
            this.starterPoint = new String[2];
            this.starterPoint[0] = firstRow[1];
            this.starterPoint[1] = firstRow[2];
            this.playerWay = firstRow[3].charAt(0);
            this.map = new char[mapSize][mapSize];
            List<String> tempList = new ArrayList<>();
            for (int i = 0; read.getFilePointer() < read.length(); i++){
                tempList.add(read.readLine());
            }
            for (int i = 0; i < tempList.size(); i++){
                for (int j = 0; j < mapSize; j++){
                    this.map[i][j] = tempList.get(i).charAt(j);
                }
            }
            read.close();
        }catch (IOException exc){
            System.out.println(exc.getMessage());
        }
    }

    public char[][] getMap() {
        return map;
    }

    public String[] getStarterPoint() {
        return starterPoint;
    }

    public char getPlayerWay() {
        return playerWay;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setPlayerWay(char playerWay) {
        this.playerWay = playerWay;
    }
}
