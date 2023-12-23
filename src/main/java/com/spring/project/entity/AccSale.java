package com.spring.project.entity;

public class AccSale {

	private int acc_id;
    private String accname;
    private int price;
    private int paycash;
    private int payupi;
    private int paycard;
    private int paycredit;
    private String date;
    private String time;
    private String username;
    
	public AccSale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccSale(int acc_id, String accname, int price, int paycash, int payupi, int paycard, int paycredit,
			String date, String time, String username) {
		super();
		this.acc_id = acc_id;
		this.accname = accname;
		this.price = price;
		this.paycash = paycash;
		this.payupi = payupi;
		this.paycard = paycard;
		this.paycredit = paycredit;
		this.date = date;
		this.time = time;
		this.username = username;
	}

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public String getAccname() {
		return accname;
	}

	public void setAccname(String accname) {
		this.accname = accname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
    
    
    
}
