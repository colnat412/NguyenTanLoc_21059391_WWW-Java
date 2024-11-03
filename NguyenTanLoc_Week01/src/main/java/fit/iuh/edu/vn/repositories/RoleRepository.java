package fit.iuh.edu.vn.repositories;

import fit.iuh.edu.vn.entities.Account;
import fit.iuh.edu.vn.entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class RoleRepository {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public RoleRepository(){
        entityManager = Persistence.createEntityManagerFactory("lab-week-01")
                .createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public void create(Role role){
        try {
            entityTransaction.begin();
            entityManager.persist(role);
            entityTransaction.commit();
        }
        catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    public void update(Role role){
        try {
            entityTransaction.begin();
            entityManager.merge(role);
            entityTransaction.commit();
        }
        catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(Role role){
        try {
            entityTransaction.begin();
            entityManager.remove(role);
            entityTransaction.commit();
        }
        catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Role> findRolesOfAccount(String email) {
        return entityManager.createNamedQuery("Role.findRolesOfAccount", Role.class)
                .setParameter("email", email)
                .getResultList();
    }
}
