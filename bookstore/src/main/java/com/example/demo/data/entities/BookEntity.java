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
	, @NamedQuery(name = "BookEntity.findBooksInStock", query =  "SELECT b FROM BookEntity b where b.inStock = true")
	, @NamedQuery(name = "BookEntity.findBooksOutOfStock", query =  "SELECT b FROM BookEntity b where b.inStock = false")
    , @NamedQuery(name = "BookEntity.findByBookId", query = "SELECT b FROM BookEntity b WHERE b.bookId = :bookId")
	, @NamedQuery(name = "BookEntity.findByBookTitle", query = "SELECT b FROM BookEntity b WHERE b.bookTitle = :bookTitle")
	, @NamedQuery(name = "BookEntity.findByPublisher", query = "SELECT b FROM BookEntity b WHERE b.publisher = :publisher")})
public class BookEntity {
	@Id
    @Column(name = "book_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    @Column(name = "avg_rating")
    private Float avgRating;
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @Column(name = "image", nullable = true)
    private byte[] image;
    @Column(name = "price", nullable = false)
    private long price;
    @Column(name = "publisher", length = 255)
    private String publisher;
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
	public BookEntity(String title, String publisher, long price, String description, byte[] image, AuthorEntity authorId,
			CategoryEntity categoryId) {
		super();
		this.bookTitle = title;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
		this.image = image;
		this.authorId = authorId;
		this.categoryId = categoryId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Float getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(Float avgRating) {
		this.avgRating = avgRating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	public Collection<OrderDetailEntity> getOrderDetailsCollection() {
		return orderDetailsCollection;
	}
	public void setOrderDetailsCollection(Collection<OrderDetailEntity> orderDetailsCollection) {
		this.orderDetailsCollection = orderDetailsCollection;
	}
	public Collection<CartEntity> getCartCollection() {
		return cartCollection;
	}
	public void setCartCollection(Collection<CartEntity> cartCollection) {
		this.cartCollection = cartCollection;
	}
	public AuthorEntity getAuthorId() {
		return authorId;
	}
	public void setAuthorId(AuthorEntity authorId) {
		this.authorId = authorId;
	}
	public CategoryEntity getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(CategoryEntity categoryId) {
		this.categoryId = categoryId;
	}
	public Collection<ReviewEntity> getReviewsCollection() {
		return reviewsCollection;
	}
	public void setReviewsCollection(Collection<ReviewEntity> reviewsCollection) {
		this.reviewsCollection = reviewsCollection;
	}
    

}