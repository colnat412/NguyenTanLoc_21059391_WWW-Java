package fit.iuh.edu.vn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InstallDBS {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("lab-week-01")
                .createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityTransaction.commit();
    }
}
