package fit.iuh.edu.vn.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "log")
@NamedQueries({
        @NamedQuery(name = "Log.findAll", query = "SELECT l from Log l"),
        @NamedQuery(name = "Log.findById", query = "SELECT l from Log l where l.id = :id"),
        @NamedQuery(name = "Log.findIdLast", query = "SELECT l from Log l order by l.id desc"),
})
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "login_time")
    private LocalDateTime loginTime;
    @Column(name = "logout_time")
    private LocalDateTime logoutTime;
    @Column(name = "note")
    private String note;
    @Column(name = "account_id")
    private String accountId;

    public Log() {
    }

    public Log(LocalDateTime loginTime, LocalDateTime logoutTime, String note, String accountId) {
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.note = note;
        this.accountId = accountId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDateTime getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(LocalDateTime logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", note='" + note + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}
