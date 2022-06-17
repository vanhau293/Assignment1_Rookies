package com.example.demo.data.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "Reviews.findAll", query = "SELECT r FROM Reviews r")
    , @NamedQuery(name = "Reviews.findByCustomerId", query = "SELECT r FROM Reviews r WHERE r.reviewsPK.customerId = :customerId")
    , @NamedQuery(name = "Reviews.findByBookId", query = "SELECT r FROM Reviews r WHERE r.reviewsPK.bookId = :bookId")})
public class Reviews {
	@EmbeddedId
    protected ReviewsPK reviewsPK;
    @Column(name = "comment", length = 2147483647)
    private String comment;
    @Column(name = "star_rating", nullable = false)
    private int starRating;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Books books;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customers customers;
    
    public Reviews() {
    	super();
    }

    public Reviews(ReviewsPK reviewsPK) {
    	super();
        this.reviewsPK = reviewsPK;
    }

    public Reviews(ReviewsPK reviewsPK, int starRating) {
    	super();
        this.reviewsPK = reviewsPK;
        this.starRating = starRating;
    }

    public Reviews(int customerId, int bookId) {
    	super();
        this.reviewsPK = new ReviewsPK(customerId, bookId);
    }
}
