package by.ayupov.entity;

import javax.persistence.*;

@Entity
@Table(name = "price", catalog = "mydb")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

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
