package fit.iuh.edu.vn.repositories;

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

    public List<Role> findRolesOfAccount(String email) {
        return entityManager.createNamedQuery("Role.findRolesOfAccount", Role.class)
                .setParameter("email", email)
                .getResultList();
    }
}
