package wumpus.view.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Entity {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        // Adatbázisműveletek végrehajtása az EntityManager-rel
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Példa: Új játékos hozzáadása
        PlayerData player = new PlayerData();
        player.setPlayerName("John Doe");
        player.setVictories(3);
        em.persist(player);

        // Példa: Játékos adatainak lekérdezése
        PlayerData retrievedPlayer = em.find(PlayerData.class, 1); // Példa: 1-es azonosítójú játékos lekérése

        // Példa: Tranzakció befejezése
        transaction.commit();

        em.close();
        JpaUtil.closeEntityManagerFactory();
    }
}
