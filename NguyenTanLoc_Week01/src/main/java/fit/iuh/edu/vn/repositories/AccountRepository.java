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

    public Account findAccountByEmail(String email){
        return entityManager.createNamedQuery("Account.findByEmail", Account.class)
                .setParameter("email", email)
                .getSingleResult();
    }
}
