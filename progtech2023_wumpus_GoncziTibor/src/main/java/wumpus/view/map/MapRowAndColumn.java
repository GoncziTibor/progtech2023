package wumpus.view.map;

import wumpus.model.Map;

public class MapRowAndColumn {
    public static void mapPrinter(Map map) {
        char[][] mapData = map.getMap();
        int rowCount = 1;

        System.out.print("  ");

        for (char c = 'A'; c < 'A' + mapData[0].length; c++) {
            System.out.print(" " + c);
        }
        System.out.println();

        for (char[] row : mapData) {
            System.out.print(rowCount + " ");
            rowCount++;
            for (char cell : row) {
                System.out.print(" " + cell);
            }
            System.out.println();
        }
    }

    public static void printMapAndPlayerInfo(Map map){
        MapRowAndColumn.mapPrinter(map);
        System.out.println("Ennyi íja vana hősnek: " + map.getPlayer().getArrows());
        System.out.println("Ebbe az irányba áll a hős: " + map.getPlayer().getDirection());
    }
}
