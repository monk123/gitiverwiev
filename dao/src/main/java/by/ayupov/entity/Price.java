package by.ayupov.entity;

import lombok.*;
import lombok.extern.java.Log;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Log
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "price")
public class Price extends BaseEntity {
    public static final long serialVersionUID = 6L;

    @Column(name = "PRICE_NEW")
    private int priceNew;

    @Column(name = "PRICE_OLD")
    private int priceOld;

    /*@OneToMany(mappedBy = "price")
    private Set<Product> priceSet = new HashSet<>();*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        if (!super.equals(o)) return false;

        Price price = (Price) o;

        if (priceNew != price.priceNew) return false;
        return priceOld == price.priceOld;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + priceNew;
        result = 31 * result + priceOld;
        return result;
    }

    @Override
    public String toString() {
        return "Price{" +
                ", priceNew=" + priceNew +
                ", priceOld=" + priceOld +
                '}';
    }
}
