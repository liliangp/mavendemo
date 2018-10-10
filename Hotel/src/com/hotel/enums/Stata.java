package com.hotel.enums;

public enum Stata {
	FULL(22, "��ס"),
	EMPATY(11, "����"),
	REPAIR(33, "ά��");
	
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
