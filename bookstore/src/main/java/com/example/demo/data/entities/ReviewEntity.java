package com.example.demo.data.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "ReviewEntity.findAll", query = "SELECT r FROM ReviewEntity r")
    , @NamedQuery(name = "ReviewEntity.findByCustomerId", query = "SELECT r FROM ReviewEntity r WHERE r.reviewPK.customerId = :customerId")
    , @NamedQuery(name = "ReviewEntity.findByBookId", query = "SELECT r FROM ReviewEntity r WHERE r.reviewPK.bookId = :bookId")})
public class ReviewEntity {
	@EmbeddedId
    protected ReviewPK reviewPK;
    @Column(name = "comment", length = 2147483647)
    private String comment;
    @Column(name = "star_rating", nullable = false)
    private int starRating;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BookEntity bookEntity;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CustomerEntity customerEntity;
    
    public ReviewEntity() {
    	super();
    }

    public ReviewEntity(ReviewPK reviewPK) {
    	super();
        this.reviewPK = reviewPK;
    }

    public ReviewEntity(ReviewPK reviewPK, int starRating) {
    	super();
        this.reviewPK = reviewPK;
        this.starRating = starRating;
    }

    public ReviewEntity(int customerId, int bookId) {
    	super();
        this.reviewPK = new ReviewPK(customerId, bookId);
    }
}
