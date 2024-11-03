package fit.iuh.edu.vn.services;

import fit.iuh.edu.vn.entities.Role;
import fit.iuh.edu.vn.repositories.RoleRepository;

import java.util.List;

public class RoleServices {
    private RoleRepository roleRepository;

    public RoleServices(){
        roleRepository = new RoleRepository();
    }

    public List<Role> findRolesOfAccount(String email) {
        return roleRepository.findRolesOfAccount(email);
    }
}
