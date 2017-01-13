package by.ayupov.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Embeddable
@Table(name = "orders", catalog = "mydb")
public class Order {

    @Column(name = "orders_number", nullable = false)
    private int orderNumber;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "orders_count", nullable = false)
    private int orderCount;

    public Order() {
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }
}
