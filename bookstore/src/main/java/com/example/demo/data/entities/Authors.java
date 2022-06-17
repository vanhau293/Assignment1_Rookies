package com.example.demo.data.entities;

import java.util.Collection;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "authors", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"author_name"})})
@Setter
@Getter
@NamedQueries({
    @NamedQuery(name = "Authors.findAll", query = "SELECT a FROM Authors a")
    , @NamedQuery(name = "Authors.findByAuthorId", query = "SELECT a FROM Authors a WHERE a.authorId = :authorId")
    , @NamedQuery(name = "Authors.findByAuthorName", query = "SELECT a FROM Authors a WHERE a.authorName = :authorName")})
public class Authors {
	@Id
    @Column(name = "author_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    @Column(name = "author_name", nullable = false, length = 100)
    private String authorName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorId")
    private Collection<Books> booksCollection;

    
	public Authors() {
		super();
	}
	public Authors(String authorName) {
		super();
		this.authorName = authorName;
	}
    
}
