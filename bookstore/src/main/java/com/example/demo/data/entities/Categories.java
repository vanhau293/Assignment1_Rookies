package com.example.demo.data.entities;

import java.util.Collection;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "categories", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"category_name"})})
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c")
    , @NamedQuery(name = "Categories.findByCategoryId", query = "SELECT c FROM Categories c WHERE c.categoryId = :categoryId")
    , @NamedQuery(name = "Categories.findByCategoryName", query = "SELECT c FROM Categories c WHERE c.categoryName = :categoryName")})
public class Categories {
	@Id
    @Column(name = "category_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column(name = "category_name", nullable = false, length = 100)
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private Collection<Books> booksCollection;

    public Categories() {
		super();
	}

	public Categories(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
    
}
