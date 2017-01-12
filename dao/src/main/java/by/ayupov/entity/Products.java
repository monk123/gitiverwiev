package by.ayupov.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "products", catalog = "mydb")
public class Products implements Serializable{

    private long product_id;
    private String articul;
}
