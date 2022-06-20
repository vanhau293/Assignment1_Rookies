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
    @NamedQuery(name = "CategoryEntity.findCategories", query = "SELECT c FROM CategoryEntity c where c.deleted = false")
    , @NamedQuery(name = "CategoryEntity.findCategoriesDeleted", query = "SELECT c FROM CategoryEntity c where c.deleted = true")
    , @NamedQuery(name = "CategoryEntity.findByCategoryId", query = "SELECT c FROM CategoryEntity c WHERE c.categoryId = :categoryId")
    , @NamedQuery(name = "CategoryEntity.findByCategoryName", query = "SELECT c FROM CategoryEntity c WHERE c.categoryName = :categoryName")})
public class CategoryEntity {
	@Id
    @Column(name = "category_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column(name = "category_name", nullable = false, length = 100)
    private String categoryName;
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private Collection<BookEntity> booksCollection;

    public CategoryEntity() {
		super();
	}

	public CategoryEntity(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Collection<BookEntity> getBooksCollection() {
		return booksCollection;
	}

	public void setBooksCollection(Collection<BookEntity> booksCollection) {
		this.booksCollection = booksCollection;
	}
	
    
}
