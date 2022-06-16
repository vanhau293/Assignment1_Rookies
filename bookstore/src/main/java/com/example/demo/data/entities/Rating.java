package com.example.demo.data.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rating")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "Rating.findAll", query = "SELECT r FROM Rating r")
    , @NamedQuery(name = "Rating.findByCustomerId", query = "SELECT r FROM Rating r WHERE r.ratingPK.customerId = :customerId")
    , @NamedQuery(name = "Rating.findByBookId", query = "SELECT r FROM Rating r WHERE r.ratingPK.bookId = :bookId")
    , @NamedQuery(name = "Rating.findByComment", query = "SELECT r FROM Rating r WHERE r.comment = :comment")
    , @NamedQuery(name = "Rating.findByStarRating", query = "SELECT r FROM Rating r WHERE r.starRating = :starRating")})
public class Rating {
	@EmbeddedId
    protected RatingPK ratingPK;
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @Column(name = "star_rating")
    private int starRating;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Book book;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;
    
    public Rating() {
    	super();
    }

    public Rating(RatingPK ratingPK) {
    	super();
        this.ratingPK = ratingPK;
    }

    public Rating(RatingPK ratingPK, int starRating) {
    	super();
        this.ratingPK = ratingPK;
        this.starRating = starRating;
    }

    public Rating(int customerId, int bookId) {
    	super();
        this.ratingPK = new RatingPK(customerId, bookId);
    }
}
