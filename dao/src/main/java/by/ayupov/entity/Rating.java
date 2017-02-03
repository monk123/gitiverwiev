package by.ayupov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import javax.persistence.*;

@Log
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rating")
public class Rating extends BaseEntity {
    public static final long serialVersionUID = 4L;

    @Column(name = "MARKS")
    private int marks;

    @Column(name = "COMMENT")
    private String comment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rating)) return false;
        if (!super.equals(o)) return false;

        Rating rating = (Rating) o;

        if (marks != rating.marks) return false;
        return comment.equals(rating.comment);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + marks;
        result = 31 * result + comment.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Rating{" +
                ", marks=" + marks +
                ", comment='" + comment + '\'' +
                '}';
    }
}
