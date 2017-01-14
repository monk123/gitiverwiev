package by.ayupov.entity;

import javax.persistence.*;

@Entity
@Table(name = "rating", catalog = "mydb")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
