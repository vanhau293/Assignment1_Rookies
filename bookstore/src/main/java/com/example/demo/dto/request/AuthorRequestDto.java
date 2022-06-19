package com.example.demo.dto.request;

import javax.validation.constraints.NotEmpty;

public class AuthorRequestDto {
		
	@NotEmpty(message = "Author name must not be null")
	private String authorName;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	
}
