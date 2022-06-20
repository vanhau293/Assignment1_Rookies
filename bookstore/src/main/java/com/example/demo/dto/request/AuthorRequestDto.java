package com.example.demo.dto.request;

import javax.validation.constraints.NotEmpty;

public class AuthorRequestDto {
		
	@NotEmpty(message = "AuthorId must not be empty")
	private String authorId;

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	
	
}
