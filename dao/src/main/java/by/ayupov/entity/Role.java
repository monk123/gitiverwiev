package by.ayupov.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles", catalog = "mydb")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private long role_id;

    @Column(name = "role_name", nullable = false, length = 20)
    private String rolename;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Role() {
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
