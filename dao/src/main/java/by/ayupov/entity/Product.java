package by.ayupov.entity;

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

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "PHOTO")
    private String photo;

    /*@ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;*/

    @OneToMany(mappedBy = "product")
    private Set<Rating> ratingSet = new HashSet<>();

   /* @ManyToOne
    @JoinColumn(name = "PRICE_ID")
    private Price price;*/

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
        if (!photo.equals(product.photo)) return false;
        if (price != product.price) return false;
        if (!categoryName.equals(product.categoryName)) return false;
        return description.equals(product.description);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + article.hashCode();
        result = 31 * result + productCount;
        result = 31 * result + description.hashCode();
        result = 31 * result + price;
        result = 31 * result + categoryName.hashCode();
        result = 31 * result + photo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", name='" + name + '\'' +
                ", article='" + article + '\'' +
                ", productsCount=" + productCount +
                ", description='" + description + '\'' +
                ", description='" + categoryName + '\'' +
                ", description='" + price + '\'' +
                ", description='" + photo + '\'' +
                '}';
    }
}
