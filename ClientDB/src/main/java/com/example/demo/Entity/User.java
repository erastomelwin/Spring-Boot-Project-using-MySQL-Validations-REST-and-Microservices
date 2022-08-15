package com.example.demo.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity(name = "Users")
public class User {

	@Id
	@Column(nullable = true)
	@Pattern(regexp = "^[a-zA-Z]{3,100}$", message = "Should have atleast 3 characters consisting only of letters [a-z] or [A-Z]")
	private String firstName;
	@Pattern(regexp = "^[a-zA-Z]{3,100}$", message = "Should have atleast 3 characters consisting only of letters [a-z] or [A-Z]")
	private String lastName;
	@NotEmpty
	@Email
	private String emailAddress;
	@Pattern(regexp = "\\d{10}", message = "Must consist of 10 characters consisting only of digits [0-9]")
	private String phoneNumber;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date date;

	@PrePersist
	private void onCreate() {
		date = new Date();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + ", phoneNumber=" + phoneNumber + ", date=" + date + "]";
	}

}
