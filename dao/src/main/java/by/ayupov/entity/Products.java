package by.ayupov.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
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
}
