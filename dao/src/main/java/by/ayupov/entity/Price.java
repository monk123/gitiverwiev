package by.ayupov.entity;

import javax.persistence.*;

@Entity
@Table(name = "price", catalog = "mydb")
public class Price {

    private long price_id;
    private int priceNew;
    private int priceOld;

    public Price() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id", nullable = false)
    public long getPrice_id() {
        return price_id;
    }

    public void setPrice_id(long price_id) {
        this.price_id = price_id;
    }

    @Column(name = "price_new", nullable = false)
    public int getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(int priceNew) {
        this.priceNew = priceNew;
    }

    @Column(name = "price_old", nullable = false)
    public int getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(int priceOld) {
        this.priceOld = priceOld;
    }
}
