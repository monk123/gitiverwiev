package by.ayupov.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles", catalog = "mydb")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (role_id != role.role_id) return false;
        return rolename.equals(role.rolename);
    }

    @Override
    public int hashCode() {
        int result = (int) (role_id ^ (role_id >>> 32));
        result = 31 * result + rolename.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
