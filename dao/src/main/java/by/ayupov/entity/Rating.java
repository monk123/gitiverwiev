package by.ayupov.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rating", catalog = "mydb")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id", nullable = false)
    private long rating_id;

    @Column(name = "marks")
    private int marks;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "products_id", nullable = false)
    private Products product;

    public Rating() {
    }

    public long getRating_id() {
        return rating_id;
    }

    public void setRating_id(long rating_id) {
        this.rating_id = rating_id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
