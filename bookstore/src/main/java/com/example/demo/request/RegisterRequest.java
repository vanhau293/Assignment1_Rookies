package com.example.demo.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterRequest {
	@NotEmpty(message = "Username must not be empty")
	@Size(min = 3, max = 20, message = "The length of the username must be between 3 and 20 characters")
	private String userName;
	@NotEmpty(message = "Password must not be empty")
	@Size(min = 6, max = 40, message = "The length of the password must be between 6 and 40 characters")
	private String password;
	@NotEmpty(message = "Name must not be empty")
	@Size(max = 255, message = "The length of the name must be less than 255 characters")
	private String name;
	@Email(message = "Invalid Email")
	@Size(max = 100, message = "The length of the password must be less than 100 characters")
	private String email;
	@NotEmpty(message = "PhoneNumber must not be empty")
	@Pattern(regexp = "^0\\d{9}", message = "Phone Number must have 10 number and start with 0")
	private String phoneNumber;
	@Size(max = 255, message = "The length of the address must be less than 255 characters")
	@NotEmpty(message = "Address must not be empty")
	private String address;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
