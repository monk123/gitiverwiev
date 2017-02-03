package by.ayupov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Log
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseEntity {
    public static final long serialVersionUID = 5L;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "ARTICLE")
    private String article;

    @Column(name = "PRODUCT_COUNT")
    private int productCount;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<Rating> ratingSet = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = {CascadeType.ALL})
    private Set<Price> priceSet = new HashSet<>();

    @ManyToMany(mappedBy = "productsSet")
    private Set<User> userSet = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        if (productCount != product.productCount) return false;
        if (!name.equals(product.name)) return false;
        if (!article.equals(product.article)) return false;
        return description.equals(product.description);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + article.hashCode();
        result = 31 * result + productCount;
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", name='" + name + '\'' +
                ", article='" + article + '\'' +
                ", productsCount=" + productCount +
                ", description='" + description + '\'' +
                '}';
    }
}
