package fit.iuh.edu.vn.repositories;

import fit.iuh.edu.vn.entities.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class AccountRepository {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public AccountRepository(){
        entityManager = Persistence.createEntityManagerFactory("lab-week-01")
                .createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public List<Account> findAll(){
        return entityManager.createNamedQuery("Account.findAll", Account.class)
                .getResultList();
    }

    public void create(Account account){
        try {
            entityTransaction.begin();
            entityManager.persist(account);
            entityTransaction.commit();
        }
        catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    public void update(Account account){
        try {
            entityTransaction.begin();
            entityManager.merge(account);
            entityTransaction.commit();
        }
        catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(Account account){
        try {
            entityTransaction.begin();
            entityManager.remove(account);
            entityTransaction.commit();
        }
        catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    public Account findAccountByEmail(String email){
        return entityManager.createNamedQuery("Account.findByEmail", Account.class)
                .setParameter("email", email)
                .getSingleResult();
    }
}
