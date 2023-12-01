package wumpus.view.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DatabaseSaver {

    private EntityManager entityManager;

    public DatabaseSaver(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveGameData(GameData gameData) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            PlayerData playerData = new PlayerData();
            playerData.setPlayerName(gameData.getPlayerName());
            playerData.setVictories(gameData.getVictories());

            entityManager.persist(playerData);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
