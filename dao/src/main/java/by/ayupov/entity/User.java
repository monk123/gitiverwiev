package by.ayupov.entity;

import by.ayupov.enums.State;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Log
@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    private static final long serialVersionUID = 2L;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL", length = 30)
    private String email;

    @Column(name = "PHONE_NUMBER")
    private int phoneNumber;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "USER_ID"),
    inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> userRole = new HashSet<>();

    @Column(name="STATE", nullable=false)
    private String state = State.ACTIVE.getState();

    @OneToMany(mappedBy = "address")
    private Set<Address> addressSet = new HashSet<>();

    public User(Integer id, String surname, String name, String email, int phoneNumber, String password) {
        super(id);
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    @ManyToMany
    @JoinTable(name = "orders",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID")})
    private Set<Product> productsSet = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (phoneNumber != user.phoneNumber) return false;
        if (!surname.equals(user.surname)) return false;
        if (!name.equals(user.name)) return false;
        if (!email.equals(user.email)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phoneNumber;
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
