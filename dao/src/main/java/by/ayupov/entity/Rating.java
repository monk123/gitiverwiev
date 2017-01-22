package by.ayupov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rating_id")
    private long rating_id;

    @Column(name = "marks")
    private int marks;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "products_id")
    private Products product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating = (Rating) o;

        if (rating_id != rating.rating_id) return false;
        if (marks != rating.marks) return false;
        return comment.equals(rating.comment);
    }

    @Override
    public int hashCode() {
        int result = (int) (rating_id ^ (rating_id >>> 32));
        result = 31 * result + marks;
        result = 31 * result + comment.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rating_id=" + rating_id +
                ", marks=" + marks +
                ", comment='" + comment + '\'' +
                '}';
    }
}
