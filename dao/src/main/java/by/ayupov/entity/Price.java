package by.ayupov.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "price", catalog = "mydb")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id", nullable = false)
    private long priceId;

    @Column(name = "price_new", nullable = false)
    private int priceNew;

    @Column(name = "price_old", nullable = false)
    private int priceOld;

    @ManyToOne
    @JoinColumn(name = "products_id", nullable = false)
    private Products product;

    public Price() {
    }

    public long getPriceId() {
        return priceId;
    }

    public void setPriceId(long priceId) {
        this.priceId = priceId;
    }

    public int getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(int priceNew) {
        this.priceNew = priceNew;
    }

    public int getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(int priceOld) {
        this.priceOld = priceOld;
    }
}
