package by.ayupov.entity;

import lombok.*;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.util.Date;

@Log
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    public static final long serialVersionUID = 4L;

    @Column(name = "ORDER_NUMBER")
    private int orderNumber;

    @Column(name = "DATE")
    @Temporal(TemporalType.TIME)
    private Date date;

    @Column(name = "ORDER_COUNT")
    private int orderCount;
}
