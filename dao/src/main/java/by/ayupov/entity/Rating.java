package by.ayupov.entity;

import javax.persistence.*;

@Entity
@Table(name = "rating", catalog = "mydb")
public class Rating {

    private long rating_id;
    private int marks;
    private String comment;

    public Rating() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id", nullable = false)
    public long getRating_id() {
        return rating_id;
    }

    public void setRating_id(long rating_id) {
        this.rating_id = rating_id;
    }

    @Column(name = "marks")
    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
