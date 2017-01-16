package by.ayupov.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderNumber != order.orderNumber) return false;
        if (orderCount != order.orderCount) return false;
        return date.equals(order.date);
    }

    @Override
    public int hashCode() {
        int result = orderNumber;
        result = 31 * result + date.hashCode();
        result = 31 * result + orderCount;
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", date=" + date +
                ", orderCount=" + orderCount +
                '}';
    }
}
