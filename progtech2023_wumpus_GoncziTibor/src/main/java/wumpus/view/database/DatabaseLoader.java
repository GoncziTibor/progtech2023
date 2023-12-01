package wumpus.view.database;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DatabaseLoader {

    private EntityManager entityManager;

    public DatabaseLoader(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public GameData loadGameData(String playerName) {
        TypedQuery<PlayerData> query = entityManager.createQuery(
                "SELECT p FROM PlayerData p WHERE p.playerName = :playerName", PlayerData.class);
        query.setParameter("playerName", playerName);

        PlayerData playerData = query.getSingleResult();
        if (playerData != null) {
            GameData gameData = new GameData();
            gameData.setPlayerName(playerData.getPlayerName());
            gameData.setVictories(playerData.getVictories());

            return gameData;
        }

        return null;
    }
}
