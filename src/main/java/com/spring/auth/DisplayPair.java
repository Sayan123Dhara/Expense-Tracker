package com.spring.auth;

public class DisplayPair<U,V> {
	private U optionValue;
	private V optionDisplayString;
	
	public U getOptionValue() {
		return optionValue;
	}
	public void setOptionValue(U optionValue) {
		this.optionValue = optionValue;
	}
	public V getOptionDisplayString() {
		return optionDisplayString;
	}
	public void setOptionDisplayString(V optionDisplayString) {
		this.optionDisplayString = optionDisplayString;
	}
	public DisplayPair(U optionValue, V optionDisplayString) {
		super();
		this.optionValue = optionValue;
		this.optionDisplayString = optionDisplayString;
	}
	public DisplayPair() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DisplayPair [optionValue=" + optionValue + ", optionDisplayString=" + optionDisplayString + "]";
	}
	
	
}
