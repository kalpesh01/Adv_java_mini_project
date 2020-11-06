package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
	@Column(name="sr_no")
	private int srNo;
	@Column(name="seat_no")
	private int seatNo;
	@Column(name="section")
	private String section;
	@Column(name="email_id")
	private String mailId;
	@Column(name = "user_id")
	private int userId;
	@Column(name="price")
	private int price;
	
	public Book() {
	}
	public Book(int seatNo, String section, String mailId, int userId, int price) {
		this.seatNo = seatNo;
		this.section = section;
		this.mailId = mailId;
		this.userId = userId;
		this.price = price;
	}
	
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return seatNo + " " + section + " " + mailId + " " + userId;
	}
	
	
	
	
}
