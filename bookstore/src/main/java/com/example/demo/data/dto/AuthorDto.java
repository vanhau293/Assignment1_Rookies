package com.example.demo.data.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AuthorDto {
		
	@Pattern(regexp = "\\d*", message = "AuthorId must be a number")
	public String authorId;
	@NotEmpty(message = "Author Name must not be empty")
	private String authorName;

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorName() {
		return authorName;
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
