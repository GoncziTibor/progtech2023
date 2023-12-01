package wumpus.view.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MyEntity {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Példa: Új játékos hozzáadása
        PlayerData player = new PlayerData();
        player.setPlayerName("John Doe");
        player.setVictories(3);
        em.persist(player);

        // Példa: Játékos adatainak lekérdezése
        PlayerData retrievedPlayer = em.find(PlayerData.class, 1); // Példa: 1-es azonosítójú játékos lekérése

        transaction.commit();

        em.close();
        JpaUtil.closeEntityManagerFactory();
    }
}
