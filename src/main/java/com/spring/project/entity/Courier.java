package com.spring.project.entity;

public class Courier {

	private int courier_id;
    private String pname;
    private int price;
    private int adv;
    private int advcash;
    private int advupi;
    private int pod;
    private String date;
    private String time;
    private String username;
   
	public int getCourier_id() {
		return courier_id;
	}

	public void setCourier_id(int courier_id) {
		this.courier_id = courier_id;
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

	public int getAdv() {
		return adv;
	}

	public void setAdv(int adv) {
		this.adv = adv;
	}

	public int getAdvcash() {
		return advcash;
	}

	public void setAdvcash(int advcash) {
		this.advcash = advcash;
	}

	public int getAdvupi() {
		return advupi;
	}

	public void setAdvupi(int advupi) {
		this.advupi = advupi;
	}

	public int getPod() {
		return pod;
	}

	public void setPod(int pod) {
		this.pod = pod;
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

	public Courier(int courier_id, String pname, int price, int adv, int advcash, int advupi, int pod, String date,
			String time, String username) {
		super();
		this.courier_id = courier_id;
		this.pname = pname;
		this.price = price;
		this.adv = adv;
		this.advcash = advcash;
		this.advupi = advupi;
		this.pod = pod;
		this.date = date;
		this.time = time;
		this.username = username;
	}

	public Courier() {
		super();
	}
    
    
}
