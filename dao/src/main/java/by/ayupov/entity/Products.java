package by.ayupov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Products implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "products_id")
    private long productId;

    @Column(name = "article")
    private String article;

    @Column(name = "products_count")
    private int productsCount;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<Rating> ratingSet;

    @OneToMany(mappedBy = "product")
    private Set<Price> priceSet;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "productsSet")
    private Set<User> userSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (productId != products.productId) return false;
        if (productsCount != products.productsCount) return false;
        if (!article.equals(products.article)) return false;
        return description.equals(products.description);
    }

    @Override
    public int hashCode() {
        int result = (int) (productId ^ (productId >>> 32));
        result = 31 * result + article.hashCode();
        result = 31 * result + productsCount;
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", article='" + article + '\'' +
                ", productsCount=" + productsCount +
                ", description='" + description + '\'' +
                '}';
    }
}
