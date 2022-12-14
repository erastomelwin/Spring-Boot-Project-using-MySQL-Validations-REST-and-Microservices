package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Integer userId;
	@Column(unique = true)
	private String name;
	@NotNull
	@Pattern(regexp = "^(1|2|5|10)$", message = "Does not accept coins other than 1,2,5 and 10")
	@Column(name ="coinDenominations")
	private String coinDenominations;
	@NotNull(message = "Atleast 1 coin has to be placed to play")
	@Column(name ="noOfCoins")
	private Integer noOfCoins;
	@NotNull(message = "Specify the total hours you want to play")
	@Column(name ="noOfHours")
	private Double noOfHours;
	@Enumerated(EnumType.STRING)
	@Column(name ="status")
	private Status status;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCoinDenominations() {
		return coinDenominations;
	}
	public void setCoinDenominations(String coinDenominations) {
		this.coinDenominations = coinDenominations;
	}
	public Integer getNoOfCoins() {
		return noOfCoins;
	}
	public void setNoOfCoins(Integer noOfCoins) {
		this.noOfCoins = noOfCoins;
	}
	public Double getNoOfHours() {
		return noOfHours;
	}
	public void setNoOfHours(Double noOfHours) {
		this.noOfHours = noOfHours;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", coinDenominations=" + coinDenominations + ", noOfCoins=" + noOfCoins
				+ ", noOfHours=" + noOfHours + ", status=" + status + "]";
	}
	
}
