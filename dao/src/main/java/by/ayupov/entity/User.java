package by.ayupov.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", catalog = "mydb")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "surname", nullable = false, length = 20)
    private String surname;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "country", nullable = false, length = 20)
    private String country;

    @Column(name = "region", nullable = false, length = 20)
    private String region;

    @Column(name = "city", nullable = false, length = 20)
    private String city;

    @Column(name = "address", nullable = false, length = 40)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private int phone_number;

    @OneToMany(mappedBy = "user")
    private Set<Role> userRole;

    @ManyToMany
    @JoinTable(name = "orders", catalog = "mydb",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "products_id", nullable = false)}
    )
    private Set<Products> productsSet;

    public User() {
    }

    public long getUser_id() {
        return userId;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setUser_id(long userId) {
        this.userId = userId;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Set<Role> getRoleSet() {
        return userRole;
    }

    public void setRoleSet(Set<Role> userRole) {
        this.userRole = userRole;
    }

    public Set<Products> getProductsSet() {
        return productsSet;
    }

    public void setProductsSet(Set<Products> productsSet) {
        this.productsSet = productsSet;
    }

}
