package wumpus.view.database;

import java.util.Map;

public class GameData {
    private String playerName;
    private int victories;
    private Map<String, Object> gameData;
    private String currentGameState;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public Map<String, Object> getGameData() {
        return gameData;
    }

    public void setGameData(Map<String, Object> gameData) {
        this.gameData = gameData;
    }

    public String getCurrentGameState() {
        return currentGameState;
    }

    public void setCurrentGameState(String currentGameState) {
        this.currentGameState = currentGameState;
    }
}

