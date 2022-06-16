package com.example.demo.data.entities;

import java.util.Collection;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "book")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
    , @NamedQuery(name = "Book.findByBookId", query = "SELECT b FROM Book b WHERE b.bookId = :bookId")
    , @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title")
    , @NamedQuery(name = "Book.findByPuslisher", query = "SELECT b FROM Book b WHERE b.puslisher = :puslisher")})
public class Book {
	@Id
    @Basic(optional = false)
    @Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "puslisher")
    private String puslisher;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "average_rating")
    private float averageRating;
    @Basic(optional = false)
    @Column(name = "price")
    private long price;
    @Basic(optional = false)
    @Column(name = "total_page")
    private int totalPage;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Lob
    @Column(name = "image")
    private byte[] image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Collection<ReceivedDetail> receivedDetailCollection;
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    @ManyToOne(optional = false)
    private Author authorId;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne(optional = false)
    private Category categoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Collection<Rating> ratingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Collection<OrderDetail> orderDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Collection<Cart> cartCollection;
	public Book() {
		super();
	}
	public Book(String title, String puslisher, long price, String description, byte[] image, Author authorId,
			Category categoryId) {
		super();
		this.title = title;
		this.puslisher = puslisher;
		this.price = price;
		this.description = description;
		this.image = image;
		this.authorId = authorId;
		this.categoryId = categoryId;
	}
    

}