package com.spring.project.entity;

public class Phonesale {
	
	private int phone_id;
    private String pname;
    private int price;
    private int paycash;
    private int payupi;
    private int paycard;
    private int paycredit;
    private String date; // Change to LocalDate
    private String time; // Change to LocalTime
    private String username;
    
	public int getPhone_id() {
		return phone_id;
	}
	public void setPhone_id(int phone_id) {
		this.phone_id = phone_id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPaycash() {
		return paycash;
	}
	public void setPaycash(int paycash) {
		this.paycash = paycash;
	}
	public int getPayupi() {
		return payupi;
	}
	public void setPayupi(int payupi) {
		this.payupi = payupi;
	}
	public int getPaycard() {
		return paycard;
	}
	public void setPaycard(int paycard) {
		this.paycard = paycard;
	}
	public int getPaycredit() {
		return paycredit;
	}
	public void setPaycredit(int paycredit) {
		this.paycredit = paycredit;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUser() {
		return username;
	}
	public void setUser(String user) {
		this.username = user;
	}
	public Phonesale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Phonesale(int phone_id, String pname, int price, int paycash, int payupi, int paycard, int paycredit,
			String date, String time, String username) {
		super();
		this.phone_id = phone_id;
		this.pname = pname;
		this.price = price;
		this.paycash = paycash;
		this.payupi = payupi;
		this.paycard = paycard;
		this.paycredit = paycredit;
		this.date = date;
		this.time = time;
		this.username = username;
	}
 
}
