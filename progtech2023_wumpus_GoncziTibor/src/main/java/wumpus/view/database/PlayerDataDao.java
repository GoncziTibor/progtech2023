package wumpus.view.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PlayerDataDao {

    public void savePlayerData(PlayerData player) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(player);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public PlayerData findPlayerDataById(int playerId) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            return em.find(PlayerData.class, playerId);
        } finally {
            em.close();
        }
    }
}