package com.example.demo.data.entities;

import java.util.Collection;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "authors", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"author_name"})})
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "AuthorEntity.findAll", query = "SELECT a FROM AuthorEntity a")
    , @NamedQuery(name = "AuthorEntity.findByAuthorId", query = "SELECT a FROM AuthorEntity a WHERE a.authorId = :authorId")
    , @NamedQuery(name = "AuthorEntity.findByAuthorName", query = "SELECT a FROM AuthorEntity a WHERE a.authorName = :authorName")})
public class AuthorEntity {
	@Id
    @Column(name = "author_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    @Column(name = "author_name", nullable = false, length = 100)
    private String authorName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorId")
    private Collection<BookEntity> booksCollection;

    
	public AuthorEntity() {
		super();
	}
	public AuthorEntity(String authorName) {
		super();
		this.authorName = authorName;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Collection<BookEntity> getBooksCollection() {
		return booksCollection;
	}
	public void setBooksCollection(Collection<BookEntity> booksCollection) {
		this.booksCollection = booksCollection;
	}
    
}
