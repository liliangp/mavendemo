package com.hotel.enums;

public enum Stata {
	FULL(22, "Èë×¡"),
	EMPATY(11, "¿ÕÏÐ"),
	REPAIR(33, "Î¬ÐÞ");
	
	private int id;
	private String desc;
	
	public int getId() {
		return id;
	}
	public String getDesc() {
		return desc;
	}
	
	Stata(int id,String desc){
		this.desc=desc;
		this.id=id;
	}
}
