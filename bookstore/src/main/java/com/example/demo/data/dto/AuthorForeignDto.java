package com.example.demo.data.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AuthorForeignDto {
	@Pattern(regexp = "\\d*", message = "AuthorId must be a number")
	@NotEmpty(message = "AuthorId must not be empty")
	private String authorId;
	public String authorName;
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	

}
