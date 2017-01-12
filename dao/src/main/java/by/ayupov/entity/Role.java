package by.ayupov.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles", catalog = "mydb")
public class Role implements Serializable {

    private long role_id;
    private String rolename;

    public Role() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    @Column(name = "role_name", nullable = false)
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
