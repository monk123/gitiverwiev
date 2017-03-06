package by.ayupov.entity;

import lombok.*;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Log
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category extends BaseEntity {
    public static final long serialVersionUID = 8L;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "DESCRIPTION")
    private String description;

   /* @OneToMany(mappedBy = "category")
    private Set<Product> productsSet = new HashSet<>();*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        if (!super.equals(o)) return false;

        Category category = (Category) o;

        if (!categoryName.equals(category.categoryName)) return false;
        return description.equals(category.description);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + categoryName.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
