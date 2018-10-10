package com.hote.entity;

import java.io.Serializable;

public class Guest implements Serializable {
	private Integer id;
	private String  names;
	private String  dataId; 
	private String  leaveDate;
	private Integer deposit;
	private String  resideDate;
	private Integer  toalMoney;
	private Room    room;
	
	
	public String getResideDate() {
		return resideDate;
	}
	public void setResideDate(String resideDate) {
		this.resideDate = resideDate;
	}
	
	public Integer getToalMoney() {
		return toalMoney;
	}
	public void setToalMoney(Integer toalMoney) {
		this.toalMoney = toalMoney;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public String getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}
	public Integer getDeposit() {
		return deposit;
	}
	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Guest(){
		
	}
    public Guest(String  names,Room room,String  leaveDate,Integer deposit,String  dataId){
    	this.names=names;
    	this.room=room;
    	this.leaveDate=leaveDate;
    	this.deposit=deposit;
    	this.dataId=dataId;
	}
	
	
}


