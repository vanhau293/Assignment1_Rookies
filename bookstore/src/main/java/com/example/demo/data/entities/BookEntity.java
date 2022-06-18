package com.example.demo.data.entities;

import java.util.Collection;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "books", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"book_title"})})
@Getter
@Setter
@NamedQueries({
	@NamedQuery(name = "BookEntity.findAll", query = "SELECT b FROM BookEntity b")
    , @NamedQuery(name = "BookEntity.findByBookId", query = "SELECT b FROM BookEntity b WHERE b.bookId = :bookId")
	, @NamedQuery(name = "BookEntity.findByBookTitle", query = "SELECT b FROM BookEntity b WHERE b.bookTitle = :bookTitle")
	, @NamedQuery(name = "BookEntity.findByPuslisher", query = "SELECT b FROM BookEntity b WHERE b.puslisher = :puslisher")})
public class BookEntity {
	@Id
    @Column(name = "book_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    @Column(name = "avg_rating")
    private Float avgRating;
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @Column(name = "image", nullable = false)
    private byte[] image;
    @Column(name = "price", nullable = false)
    private long price;
    @Column(name = "puslisher", length = 255)
    private String puslisher;
    @Column(name = "book_title", nullable = false, length = 255)
    private String bookTitle;
    @Column(name = "total_page", nullable = false)
    private int totalPage;
    @Column(name = "in_stock", nullable = false)
    private boolean inStock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookEntity")
    private Collection<OrderDetailEntity> orderDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookEntity")
    private Collection<CartEntity> cartCollection;
    @JoinColumn(name = "author_id", referencedColumnName = "author_id", nullable = false)
    @ManyToOne(optional = false)
    private AuthorEntity authorId;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    @ManyToOne(optional = false)
    private CategoryEntity categoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookEntity")
    private Collection<ReviewEntity> reviewsCollection;
	public BookEntity() {
		super();
	}
	public BookEntity(String title, String puslisher, long price, String description, byte[] image, AuthorEntity authorId,
			CategoryEntity categoryId) {
		super();
		this.bookTitle = title;
		this.puslisher = puslisher;
		this.price = price;
		this.description = description;
		this.image = image;
		this.authorId = authorId;
		this.categoryId = categoryId;
	}
    

}