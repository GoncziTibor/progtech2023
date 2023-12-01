package wumpus.view.database;
import javax.persistence.*;

@Entity
@Table(name = "players")
public class PlayerData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "victories")
    private int victories;

    @Column(name = "player_data", columnDefinition = "TEXT")
    private String playerData;

    @Column(name = "current_game_state", columnDefinition = "TEXT")
    private String currentGameState;

    // Getterek és setterek...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getPlayerData() {
        return playerData;
    }

    public void setPlayerData(String playerData) {
        this.playerData = playerData;
    }

    public String getCurrentGameState() {
        return currentGameState;
    }

    public void setCurrentGameState(String currentGameState) {
        this.currentGameState = currentGameState;
    }
}
