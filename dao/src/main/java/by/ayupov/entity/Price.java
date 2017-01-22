package by.ayupov.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "price", catalog = "mydb")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "price_id")
    private long priceId;

    @Column(name = "price_new")
    private int priceNew;

    @Column(name = "price_old")
    private int priceOld;

    @ManyToOne
    @JoinColumn(name = "products_id")
    private Products product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        if (priceId != price.priceId) return false;
        if (priceNew != price.priceNew) return false;
        return priceOld == price.priceOld;
    }

    @Override
    public int hashCode() {
        int result = (int) (priceId ^ (priceId >>> 32));
        result = 31 * result + priceNew;
        result = 31 * result + priceOld;
        return result;
    }

    @Override
    public String toString() {
        return "Price{" +
                "priceId=" + priceId +
                ", priceNew=" + priceNew +
                ", priceOld=" + priceOld +
                '}';
    }
}
