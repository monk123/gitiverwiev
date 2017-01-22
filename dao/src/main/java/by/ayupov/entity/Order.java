package by.ayupov.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orders")
    private int orderId;

    @Column(name = "orders_number")
    private int orderNumber;

    @Column(name = "date")
    @Temporal(TemporalType.TIME)
    private Date date;

    @Column(name = "orders_count")
    private int orderCount;
}
