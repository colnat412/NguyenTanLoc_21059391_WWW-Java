package fit.iuh.edu.vn.entities;

import fit.iuh.edu.vn.enums.GrantAccessStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "grant_access")

public class GrantAccess {
    @Id
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "is_grant")
    @Enumerated(EnumType.ORDINAL)
    private GrantAccessStatus isGrant;

    @Column(name = "note")
    private String note;

    public GrantAccess() {
    }

    public GrantAccess(Account account, Role role, GrantAccessStatus isGrant, String note) {
        this.account = account;
        this.role = role;
        this.isGrant = isGrant;
        this.note = note;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public GrantAccessStatus getIsGrant() {
        return isGrant;
    }

    public void setIsGrant(GrantAccessStatus isGrant) {
        this.isGrant = isGrant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "account=" + account.getId() +
                ", role=" + role.getId() +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }
}
