package by.ayupov.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category", catalog = "mydb")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", nullable = false)
    private long category_id;

    @Column(name = "category_name", nullable = false, length = 45)
    private String categoryName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Products> productsSet;

    public Category() {
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Products> getProductsSet() {
        return productsSet;
    }

    public void setProductsSet(Set<Products> productsSet) {
        this.productsSet = productsSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (category_id != category.category_id) return false;
        if (!categoryName.equals(category.categoryName)) return false;
        return description.equals(category.description);
    }

    @Override
    public int hashCode() {
        int result = (int) (category_id ^ (category_id >>> 32));
        result = 31 * result + categoryName.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
