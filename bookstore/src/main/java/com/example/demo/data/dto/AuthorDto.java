package com.example.demo.data.dto;

import javax.validation.constraints.NotEmpty;

public class AuthorDto {
		
	
	private String authorId;
	@NotEmpty(message = "Author Name must not be empty")
	private String authorName;
	

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public AuthorDto(String authorId, @NotEmpty(message = "Author Name must not be empty") String authorName) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
	}

	public AuthorDto() {
		super();
	}

	
	
}
