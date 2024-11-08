package fit.iuh.edu.vn.repositories;

import fit.iuh.edu.vn.entities.Log;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class LogRepository {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public LogRepository(){
        entityManager = Persistence.createEntityManagerFactory("lab-week-01")
                .createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public void create(Log log) {
        try {
            entityTransaction.begin();
            entityManager.persist(log);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    public void update(Log log) {
        try {
            entityTransaction.begin();
            entityManager.merge(log);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(Log log) {
        try {
            entityTransaction.begin();
            entityManager.remove(log);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Log> findLogByAccountId(String accountId) {
        return entityManager.createNamedQuery("Log.findByAccountId", Log.class)
                .setParameter("accountId", accountId)
                .getResultList();
    }

    public Log findIdLast() {
        return entityManager.createNamedQuery("Log.findIdLast", Log.class)
                .setMaxResults(1)
                .getSingleResult();
    }
}
