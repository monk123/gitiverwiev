package by.ayupov.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products", catalog = "mydb")
public class Products implements Serializable{

    private long product_id;
    private String articul;
    private int productsCount;
    private String description;
    private Set<Rating> ratingSet = new HashSet<Rating>(0);
    private Set<Price> priceSet = new HashSet<Price>(0);
    private Set<User> userSet = new HashSet<User>(0);

    public Products() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "products_id", nullable = false)
    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    @Column(name = "articul", length = 20)
    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    @Column(name = "products_count")
    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
    public Set<Rating> getRatingSet() {
        return ratingSet;
    }

    public void setRatingSet(Set<Rating> ratingSet) {
        this.ratingSet = ratingSet;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
    public Set<Price> getPriceSet() {
        return priceSet;
    }

    public void setPriceSet(Set<Price> priceSet) {
        this.priceSet = priceSet;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
