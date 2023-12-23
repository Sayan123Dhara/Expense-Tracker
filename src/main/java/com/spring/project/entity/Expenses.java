package com.spring.project.entity;

public class Expenses {

	private int exp_id;
    private String reason;
    private int amt;
    private int amtcash;
    private int amtupi;
    private String date;
    private String time;
    private String username;
    
	public int getExp_id() {
		return exp_id;
	}
	public void setExp_id(int exp_id) {
		this.exp_id = exp_id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	public int getAmtcash() {
		return amtcash;
	}
	public void setAmtcash(int amtcash) {
		this.amtcash = amtcash;
	}
	public int getAmtupi() {
		return amtupi;
	}
	public void setAmtupi(int amtupi) {
		this.amtupi = amtupi;
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
	public Expenses(int exp_id, String reason, int amt, int amtcash, int amtupi, String date, String time,
			String username) {
		super();
		this.exp_id = exp_id;
		this.reason = reason;
		this.amt = amt;
		this.amtcash = amtcash;
		this.amtupi = amtupi;
		this.date = date;
		this.time = time;
		this.username = username;
	}
	public Expenses() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}
