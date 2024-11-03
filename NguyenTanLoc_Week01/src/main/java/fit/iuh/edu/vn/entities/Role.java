package fit.iuh.edu.vn.entities;

import fit.iuh.edu.vn.enums.Status;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "role")
@NamedQueries({
        @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
        @NamedQuery(name = "Role.findRolesOfAccount", query = "SELECT r FROM Role r JOIN r.grantAccesses ga WHERE ga.account.email = :email")
})
public class Role {
    @Id
    @Column(name="role_id")
    private String id;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
    private List<GrantAccess> grantAccesses;

    public Role() {
    }

    public Role(String roleName, String description, Status status) {
        this.roleName = roleName;
        this.description = description;
        this.status = status;
    }

    // Auto generate UUID for id
    @PrePersist
    private void generateId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<GrantAccess> getGrantAccesses() {
        return grantAccesses;
    }

    public void setGrantAccesses(List<GrantAccess> grantAccesses) {
        this.grantAccesses = grantAccesses;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
