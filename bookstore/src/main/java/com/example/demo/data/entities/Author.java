package com.example.demo.data.entities;

import java.util.Collection;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "author")
@Setter
@Getter
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a")
    , @NamedQuery(name = "Author.findByAuthorId", query = "SELECT a FROM Author a WHERE a.authorId = :authorId")
    , @NamedQuery(name = "Author.findByAuthorName", query = "SELECT a FROM Author a WHERE a.authorName = :authorName")})
public class Author {
	@Id
    @Basic(optional = false)
    @Column(name = "author_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    @Basic(optional = false)
    @Column(name = "author_name")
    private String authorName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorId", fetch = FetchType.LAZY)
    private Collection<Book> bookCollection;
    
	public Author() {
		super();
	}
	public Author(String authorName) {
		super();
		this.authorName = authorName;
	}
    
}
