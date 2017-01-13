package by.ayupov.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", catalog = "mydb")
public class User implements Serializable{

    private long user_id;
    private String surname;
    private String name;
    private String email;
    private String country;
    private String region;
    private String city;
    private String address;
    private int phone_number;
    private long role_id;
    private Set<Role> roleSet = new HashSet<Role>(0);
    private Set<Products> productsSet = new HashSet<Products>(0);

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    public long getUser_id() {
        return user_id;
    }

    @Column(name = "surname", nullable = false, length = 20)
    public String getSurname() {
        return surname;
    }

    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    @Column(name = "country", nullable = false, length = 20)
    public String getCountry() {
        return country;
    }

    @Column(name = "region", nullable = false, length = 20)
    public String getRegion() {
        return region;
    }

    @Column(name = "city", nullable = false, length = 20)
    public String getCity() {
        return city;
    }

    @Column(name = "address", nullable = false, length = 40)
    public String getAddress() {
        return address;
    }

    @Column(name = "phone_number", nullable = false)
    public int getPhone_number() {
        return phone_number;
    }


    public long getRole_id() {
        return role_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Role> getRoleSet() {
        return this.roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "orders", catalog = "mydb",
            joinColumns = @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id", referencedColumnName = "products_id")
    )
    public Set<Products> getProductsSet() {
        return productsSet;
    }

    public void setProductsSet(Set<Products> productsSet) {
        this.productsSet = productsSet;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", phone_number=" + phone_number +
                ", role_id=" + role_id +
                '}';
    }
}
