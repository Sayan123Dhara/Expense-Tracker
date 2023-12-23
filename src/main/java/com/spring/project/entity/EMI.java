package com.spring.project.entity;

public class EMI {

	private int emi_id;
    private String pname;
    private int price;
    private int dpaycash;
    private int dpayupi;
    private int dpaycard;
    private int restamt;
    private String date;
    private String time;
    private String username;
    
	public int getEmi_id() {
		return emi_id;
	}
	public void setEmi_id(int emi_id) {
		this.emi_id = emi_id;
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
	public int getDpaycash() {
		return dpaycash;
	}
	public void setDpaycash(int dpaycash) {
		this.dpaycash = dpaycash;
	}
	public int getDpayupi() {
		return dpayupi;
	}
	public void setDpayupi(int dpayupi) {
		this.dpayupi = dpayupi;
	}
	public int getDpaycard() {
		return dpaycard;
	}
	public void setDpaycard(int dpaycard) {
		this.dpaycard = dpaycard;
	}
	public int getRestamt() {
		return restamt;
	}
	public void setRestamt(int restamt) {
		this.restamt = restamt;
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
	public EMI(int emi_id, String pname, int price, int dpaycash, int dpayupi, int dpaycard, int restamt,
			String date, String time, String username) {
		super();
		this.emi_id = emi_id;
		this.pname = pname;
		this.price = price;
		this.dpaycash = dpaycash;
		this.dpayupi = dpayupi;
		this.dpaycard = dpaycard;
		this.restamt = restamt;
		this.date = date;
		this.time = time;
		this.username = username;
	}
	public EMI() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
