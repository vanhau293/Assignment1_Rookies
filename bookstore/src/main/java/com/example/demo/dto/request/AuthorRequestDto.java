package com.example.demo.dto.request;

import javax.validation.constraints.NotEmpty;

public class AuthorRequestDto {
		
	
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

	
	
}
