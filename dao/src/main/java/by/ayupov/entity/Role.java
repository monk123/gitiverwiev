package by.ayupov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private long role_id;

    @Column(name = "role_name")
    private String rolename;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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
